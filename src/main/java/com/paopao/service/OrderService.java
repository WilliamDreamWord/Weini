package com.paopao.service;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.paopao.common.Const;
import com.paopao.common.OrderConst;
import com.paopao.dao.*;
import com.paopao.po.*;
import com.paopao.po.Package;
import com.paopao.util.DateTimeUtil;
import com.paopao.vo.OrderItemManagerVo;
import com.paopao.vo.OrderItemVo;
import com.paopao.vo.OrderManagerVo;
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

    @Autowired
    private OrderShippingMapper orderShippingMapper;

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
        orderVo.setPaymentTypeDesc(OrderConst.PaymentType.codeOf(order.getPaymentType()).getVal());
        orderVo.setStatus(order.getStatus());
        orderVo.setStatusDesc(OrderConst.OrderStatusEnum.codeOf(order.getStatus()).getValue());

        orderVo.setShippingId(order.getShippingId());
        //这里的shipping对应order_shipping表，而不是shipping表
        OrderShipping orderShipping = orderShippingMapper.selectByPrimaryKey(order.getShippingId());
        if (orderShipping != null) {
            orderVo.setReceiverName(orderShipping.getReceiverName());
            orderVo.setShipping(orderShipping);
        }


        orderVo.setCreateTime(DateTimeUtil.dateToStr(order.getCreateTime()));
        orderVo.setGetTime(DateTimeUtil.dateToStr(order.getGetTime()));
        orderVo.setEndTime(DateTimeUtil.dateToStr(order.getEndTime()));
        orderVo.setCloseTime(DateTimeUtil.dateToStr(order.getCloseTime()));


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
    public OrderVo addOrder(Integer packageId, Integer shippingId, Integer userId) {
        if (packageId == null || shippingId == null || userId == null) {
            throw new IllegalArgumentException("传入的参数项为null");
        }

        long orderNo = generateOrderNo();

        OrderItem orderItem = new OrderItem();
        Package pack = packageMapper.selectByPrimaryKey(packageId);
        Preconditions.checkArgument(pack!=null, "没有相关包裹");
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
        order.setPaymentType(OrderConst.PaymentType.OFFLINE_PAY.getCode());
        order.setStatus(OrderConst.OrderStatusEnum.PUBLISH_ORDER.getCode());

        //把shipping转化为orderShipping
        Shipping shipping = shippingMapper.selectByPrimaryKey(shippingId);
        OrderShipping orderShipping = new OrderShipping();
        orderShipping.setOrderNo(orderNo);
        orderShipping.setUserId(userId);
        orderShipping.setReceiverName(shipping.getReceiverName());
        orderShipping.setShippingStatus(shipping.getStatus());
        orderShipping.setReceiverMobile(shipping.getReceiverMobile());
        orderShipping.setReceiverSmallArea(shipping.getReceiverSmallArea());
        orderShipping.setReceiverMediumArea(shipping.getReceiverMediumArea());
        orderShipping.setReceiverLargeArea(shipping.getReceiverLargeArea());
        orderShipping.setReceiverDoor(shipping.getReceiverDoor());
        int row = orderShippingMapper.insert(orderShipping);
        Preconditions.checkArgument(row > 0, "插入orderShipping失败");

        order.setShippingId(orderShipping.getId());

        int ans = orderMapper.insert(order);
        Preconditions.checkArgument(ans > 0, "下单失败");



        OrderVo orderVo = assembleOrderVo(order, Arrays.asList(orderItem));
        return orderVo;
    }



    public OrderVo getOrder(Integer userId, Long orderNo) {
        Order order = orderMapper.selectByUserIdAndOrderNo(userId, orderNo);
        Preconditions.checkArgument(order!=null, "没有找到该订单");
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
            List<OrderItem> orderItemList;
            if (userId == null) {
                //管理员查询
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


    public int countByStatus(Integer status) {
        return orderMapper.countByUserIdStatus(null, status);
    }

    public int countByUserId(Integer userId) {
        return orderMapper.countByUserIdStatus(userId, null);
    }


    /**
     *
     *      manager
     *
     */

    private OrderItemManagerVo assembleOrderItemManagerVo(OrderItem orderItem, Package pack) {
        OrderItemManagerVo orderItemManagerVo = new OrderItemManagerVo();
        orderItemManagerVo.setOrderNo(orderItem.getOrderNo());
        orderItemManagerVo.setPack(pack);

        orderItemManagerVo.setCreateTime(DateTimeUtil.dateToStr(orderItem.getCreateTime()));

        return orderItemManagerVo;
    }

    private OrderItemManagerVo assembleOrderItemManagerVo(OrderItem orderItem) {
        Package pack = packageMapper.selectByPrimaryKey(orderItem.getPackageId());
        Preconditions.checkArgument(pack!=null, "没有相关包裹");
        return assembleOrderItemManagerVo(orderItem, pack);
    }

    private List<OrderItemManagerVo> assembleOrderItemManagerVoList(List<OrderItem> orderItemList) {
        List<OrderItemManagerVo> orderItemManagerVoList = new ArrayList<>();
        for (OrderItem orderItem : orderItemList) {
            orderItemManagerVoList.add(assembleOrderItemManagerVo(orderItem));
        }
        return orderItemManagerVoList;
    }


    private OrderManagerVo assembleOrderManagerVo(Order order, List<OrderItemManagerVo> orderItemManagerVos) {
        OrderManagerVo orderManagerVo = new OrderManagerVo();


        orderManagerVo.setOrderNo(order.getOrderNo());
        orderManagerVo.setPayment(order.getPayment());
        orderManagerVo.setPaymentType(order.getPaymentType());
        orderManagerVo.setPaymentTypeDesc(OrderConst.PaymentType.codeOf(order.getPaymentType()).getVal());
        orderManagerVo.setStatus(order.getStatus());
        orderManagerVo.setStatusDesc(OrderConst.OrderStatusEnum.codeOf(order.getStatus()).getValue());

        orderManagerVo.setShippingId(order.getShippingId());

        //这里的shipping对应order_shipping表，而不是shipping表
        OrderShipping orderShipping = orderShippingMapper.selectByPrimaryKey(order.getShippingId());
        if (orderShipping != null) {
            orderManagerVo.setReceiverName(orderShipping.getReceiverName());
            orderManagerVo.setShipping(orderShipping);
        }


        orderManagerVo.setOrderCount(orderMapper.countByUserIdStatus(order.getUserId(), null));
        orderManagerVo.setCreateTime(DateTimeUtil.dateToStr(order.getCreateTime()));
        orderManagerVo.setGetTime(DateTimeUtil.dateToStr(order.getGetTime()));
        orderManagerVo.setEndTime(DateTimeUtil.dateToStr(order.getEndTime()));
        orderManagerVo.setCloseTime(DateTimeUtil.dateToStr(order.getCloseTime()));


        orderManagerVo.setOrderItemVoList(orderItemManagerVos);

        return orderManagerVo;
    }

    private List<OrderManagerVo> assembleOrderManagerVoList(List<Order> orderList, Integer userId) {
        List<OrderManagerVo> orderVoList = Lists.newArrayList();
        for (Order order : orderList) {
            List<OrderItem> orderItemList;
            if (userId == null) {
                //管理员查询
                orderItemList = orderItemMapper.getByOrderNo(order.getOrderNo());
            } else {
                orderItemList = orderItemMapper.getByOrderNoUserId(
                        order.getOrderNo(), userId);
            }

            List<OrderItemManagerVo> orderItemManagerVoList = assembleOrderItemManagerVoList(orderItemList);
            OrderManagerVo orderVo = assembleOrderManagerVo(order, orderItemManagerVoList);
            orderVoList.add(orderVo);

        }
        return orderVoList;
    }




    public List<OrderManagerVo> manageList(int pageNum, int pageSize) {

        List<Order> orderList = orderMapper.selectAllOrder((pageNum-1)*pageSize, pageSize);
        List<OrderManagerVo> orderManagerVos = assembleOrderManagerVoList(orderList,null);

        return orderManagerVos;
    }

    public OrderManagerVo manageDetail(Long orderNo) {
        Order order = orderMapper.selectByOrderNo(orderNo);
        Preconditions.checkArgument(order!=null, "订单不存在");
        List<OrderItem> orderItems = orderItemMapper.getByOrderNo(orderNo);
        return assembleOrderManagerVo(order, assembleOrderItemManagerVoList(orderItems));
    }



    //改变订单状态
    public void manageChangeOrderStatus(Long orderNo, Integer status) {
        Order order = orderMapper.selectByOrderNo(orderNo);
        Preconditions.checkArgument(order!=null, "订单不存在");
        OrderConst.OrderStatusEnum orderStatus = OrderConst.OrderStatusEnum.codeOf(status);
        Preconditions.checkArgument(orderStatus!=null, "不存在该状态");

        // TODO: 02/09/2018
        switch (orderStatus) {
            //下单
            case PUBLISH_ORDER: {
                order.setCreateTime(new Date());
                break;
            }
            //接单
            case GET_ORDER: {
                order.setGetTime(new Date());
                break;
            }
            //签收，
            case SIGN: {
                order.setEndTime(new Date());
                break;
            }
            //取消
            case CANCELED: {
                order.setCloseTime(new Date());
                break;
            }
        }
        order.setStatus(status);
        orderMapper.updateByOrderNo(order);
    }




    public int manageCountAll() {
        return orderMapper.countAll();
    }



    public List<OrderManagerVo> selectByDateStatus(String beginStr, String endStr, Integer status) {
        Date begin = DateTimeUtil.strToDate(beginStr.trim());
        Date end = DateTimeUtil.strToDate(endStr.trim());
        return selectByDateStatus(begin, end, status);
    }

    public List<OrderManagerVo> selectByDateStatusNow(String beginStr, Integer status) {
        Date begin = DateTimeUtil.strToDate(beginStr.trim());
        return selectByDateStatus(begin, new Date(), status);

    }

    public List<OrderManagerVo> selectByDateStatus(Date begin, Date end, Integer status) {
        List<Order> orderList =  orderMapper.selectByUserIdDateStatus(begin, end, status);
        List<OrderManagerVo> orderManagerVos = new ArrayList<>();
        for (Order order : orderList) {
            List<OrderItem> orderItems = orderItemMapper.getByOrderNo(order.getOrderNo());
            orderManagerVos.add(assembleOrderManagerVo(order, assembleOrderItemManagerVoList(orderItems)));
        }
        return orderManagerVos;
    }


}
