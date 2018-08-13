package com.paopao.service;

import com.google.common.base.Preconditions;
import com.paopao.common.Const;
import com.paopao.dao.OrderItemMapper;
import com.paopao.dao.OrderMapper;
import com.paopao.dao.PackageMapper;
import com.paopao.po.Order;
import com.paopao.po.OrderItem;
import com.paopao.po.Package;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

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

    //当前时间加随机数生产订单号
    private long generateOrderNo() {
        long currentTime = System.currentTimeMillis();
        return currentTime+new Random().nextInt(100);
    }


    //目前为止，直接通过packageId来添加订单
    public Order addOrder(int packageId, int shippingId, int userId) {

        long orderNo = generateOrderNo();

        OrderItem orderItem = new OrderItem();
        Package pack = packageMapper.selectByPrimaryKey(packageId);
        Preconditions.checkNotNull(pack, "没有相关包裹");
        Preconditions.checkArgument(pack.getStatus() == Const.PackageStatus.WAIT.getCode(),
                "订单状态异常,请查看订单是否为等待状态");


        orderItem.setUserId(userId);
        orderItem.setPackageId(packageId);
        orderItem.setOrderNo(orderNo);
        orderItem.setPackageName(pack.getName());
        orderItem.setPrice(pack.getPrice());

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

        return order;

    }

}
