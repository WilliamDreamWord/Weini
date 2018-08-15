package com.paopao.service;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.paopao.common.Const;
import com.paopao.dao.OrderItemMapper;
import com.paopao.dao.OrderMapper;
import com.paopao.dao.PackageMapper;
import com.paopao.dao.ShippingMapper;
import com.paopao.po.Order;
import com.paopao.po.OrderItem;
import com.paopao.po.Package;
import com.paopao.po.Shipping;
import com.paopao.util.DateTimeUtil;
import com.paopao.vo.OrderItemVo;
import com.paopao.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by joker on 13/08/2018.
 */
@Service
public class OrderService {


    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private PackageMapper packageMapper;

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Autowired
    private ShippingMapper shippingMapper;

    //当前时间加随机数生产订单号
    private long generateOrderNo() {
        long currentTime = System.currentTimeMillis();
        return currentTime+new Random().nextInt(100);
    }

    private OrderVo assembleOrderVo(Order order, List<OrderItem> orderItemList) {
        OrderVo orderVo = new OrderVo();

        orderVo.setOrderNo(order.getOrderNo());
        orderVo.setPayment(order.getPayment());
        orderVo.setPaymentType(order.getPaymentType());
        orderVo.setPaymentTypeDesc(Const.PaymentType.codeOf(order.getPaymentType()).getVal());
        orderVo.setStatus(order.getStatus());
        orderVo.setStatusDesc(Const.OrderStatusEnum.codeOf(order.getStatus()).getValue());

        orderVo.setShippingId(order.getShippingId());
        Shipping shipping = shippingMapper.selectByPrimaryKey(order.getShippingId());
        if (shipping != null) {
            orderVo.setReceiverName(shipping.getReceiverName());
            orderVo.setShipping(shipping);
        }


        orderVo.setCreateTime(order.getCreateTime());
        orderVo.setGetTime(order.getGetTime());
        orderVo.setEndTime(order.getEndTime());
        orderVo.setCloseTime(order.getCloseTime());


        List<OrderItemVo> orderItemVoList = Lists.newArrayList();
        for (OrderItem orderItem : orderItemList) {
            OrderItemVo orderItemVo = assembleOrderItemVo(orderItem);
            orderItemVoList.add(orderItemVo);
        }
        orderVo.setOrderItemVoList(orderItemVoList);

        return orderVo;
    }

    private OrderItemVo assembleOrderItemVo(OrderItem orderItem) {
        OrderItemVo orderItemVo = new OrderItemVo();
        orderItemVo.setOrderNo(orderItem.getOrderNo());
        orderItemVo.setPackageId(orderItem.getPackageId());
        orderItemVo.setPackageName(orderItem.getPackageName());
        orderItemVo.setPrice(orderItem.getPrice());

        orderItemVo.setCreateTime(DateTimeUtil.dateToStr(orderItem.getCreateTime()));

        return orderItemVo;
    }


    //目前为止，直接通过packageId来添加订单
    public OrderVo addOrder(int packageId, int shippingId, int userId) {

        long orderNo = generateOrderNo();

        OrderItem orderItem = new OrderItem();
        Package pack = packageMapper.selectByPrimaryKey(packageId);
        Preconditions.checkNotNull(pack, "没有相关包裹");
        Preconditions.checkArgument(pack.getStatus() == Const.PackageStatus.WAIT.getCode(),
                "包裹状态异常,请查看订单是否为等待状态");


        orderItem.setUserId(userId);
        orderItem.setPackageId(packageId);
        orderItem.setOrderNo(orderNo);
        orderItem.setPackageName(pack.getName());
        orderItem.setPrice(pack.getPrice());
        orderItem.setCreateTime(pack.getCreateTime());

        orderItemMapper.insert(orderItem);

        Order order = new Order();
        order.setOrderNo(orderNo);
        order.setUserId(userId);
        order.setPayment(orderItem.getPrice());
        order.setPaymentType(Const.PaymentType.OFFLINE_PAY.getCode());
        order.setShippingId(shippingId);
        order.setStatus(Const.OrderStatusEnum.PUBLISH_ORDER.getCode());

        int ans = orderMapper.insert(order);
        Preconditions.checkArgument(ans > 0, "下单失败");



        OrderVo orderVo = assembleOrderVo(order, Arrays.asList(orderItem));
        return orderVo;
    }

    public void cancel(Integer userId, Long orderNo) {
        Order order = orderMapper.selectByUserIdAndOrderNo(userId, orderNo);
        Preconditions.checkNotNull(order, "该用户的改订单不存在");
        Preconditions.checkArgument(order.getStatus() != Const.OrderStatusEnum.SIGN.getCode(),
                "该订单已签收，无法取消");
        Order updateOrder = new Order();
        updateOrder.setId(order.getId());
        updateOrder.setStatus(Const.OrderStatusEnum.CANCELED.getCode());
        int row = orderMapper.updateByPrimaryKeySelective(updateOrder);
        Preconditions.checkArgument(row>0, "取消订单失败");
    }

    public OrderVo getOrder(Integer userId, Long orderNo) {
        Order order = orderMapper.selectByUserIdAndOrderNo(userId, orderNo);
        Preconditions.checkNotNull(order, "没有找到该订单");
        List<OrderItem> orderItemList = orderItemMapper.getByOrderNoUserId(orderNo, userId);
        OrderVo orderVo = assembleOrderVo(order, orderItemList);

        return orderVo;
    }

    public List<OrderVo> getOrderList(Integer userId, int pageNum, int pageSize) {
        List<Order> orderList = orderMapper.selectByUserId(userId, (pageNum-1)*pageSize, pageSize);
        List<OrderVo> orderVoList = assembleOrderVoList(orderList, userId);

        return orderVoList;
    }

    private List<OrderVo> assembleOrderVoList(List<Order> orderList, Integer userId) {
        List<OrderVo> orderVoList = Lists.newArrayList();
        for (Order order : orderList) {
            List<OrderItem> orderItemList = Lists.newArrayList();
            if (userId == null) {
                //todo 管理员查询
                orderItemList = orderItemMapper.getByOrderNo(order.getOrderNo());
            } else {
                orderItemList = orderItemMapper.getByOrderNoUserId(
                        order.getOrderNo(), userId);
            }
            OrderVo orderVo = assembleOrderVo(order, orderItemList);
            orderVoList.add(orderVo);

        }
        return orderVoList;
    }



    //manager

    public List<OrderVo> manageList(int pageNum, int pageSize) {

        List<Order> orderList = orderMapper.selectAllOrder((pageNum-1)*pageSize, pageSize);
        List<OrderVo> orderVoList = assembleOrderVoList(orderList,null);

        return orderVoList;
    }

    public OrderVo manageDetail(Long orderNo) {
        Order order = orderMapper.selectByOrderNo(orderNo);
        Preconditions.checkNotNull(order, "订单不存在");
        List<OrderItem> orderItems = orderItemMapper.getByOrderNo(orderNo);
        return assembleOrderVo(order, orderItems);
    }


    public List<OrderVo> manageSearchByUserId(Integer userId, int pageNum, int pageSize) {
        List<Order> orders = orderMapper.selectByUserId(userId, pageNum, pageSize);
        List<OrderVo> orderVoList = new ArrayList<>();
        for (Order order : orders) {
            List<OrderItem> orderItems = orderItemMapper.getByOrderNo(order.getOrderNo());
            orderVoList.add(assembleOrderVo(order, orderItems));
        }
        return orderVoList;
    }


    //接单
    public void manageSendGoods(Long orderNo) {
        Order order = orderMapper.selectByOrderNo(orderNo);
        Preconditions.checkNotNull(order, "订单不存在");
        if (order.getStatus() == Const.OrderStatusEnum.PUBLISH_ORDER.getCode()) {
            order.setStatus(Const.OrderStatusEnum.GET_ORDER.getCode());
            order.setGetTime(new Date());
            orderMapper.updateByPrimaryKeySelective(order);
        }
    }










}