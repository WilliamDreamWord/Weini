package com.paopao.service;

import com.google.common.base.Preconditions;
import com.paopao.common.OrderConst;
import com.paopao.dao.OrderMapper;
import com.paopao.dao.OrderReturnApplyMapper;
import com.paopao.po.Order;
import com.paopao.po.OrderReturnApply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by joker on 06/09/2018.
 */
@Service
public class OrderReturnApplyService {

    @Autowired
    private OrderReturnApplyMapper orderReturnApplyMapper;

    @Autowired
    private OrderMapper orderMapper;




    public OrderReturnApply selectById(Integer id) {
        OrderReturnApply orderReturnApply = orderReturnApplyMapper.selectByPrimaryKey(id);
        Preconditions.checkArgument(orderReturnApply != null, "没有相关的申请");

        return orderReturnApply;
    }


    public void add(Integer userId, Long orderNo, String way) {

        Order order = orderMapper.selectByOrderNo(orderNo);
        OrderReturnApply orderReturnApply = new OrderReturnApply();
        orderReturnApply.setOrderNo(orderNo);
        orderReturnApply.setUserId(userId);
        orderReturnApply.setWhy(way);
        orderReturnApply.setAuditStatus(OrderConst.OrderReturnApplyEnum.NON_AUDIT.getCode());

        orderReturnApply.setOrderStatus(order.getStatus());
        //目前只有包裹的退单申请
        orderReturnApply.setType(OrderConst.OrderReturnApplyTypeEnum.PACKAGE.getCode());

        int row = orderReturnApplyMapper.insert(orderReturnApply);
        Preconditions.checkArgument(row > 0, "插入退单申请失败");
    }


    public void delete(Integer id) {
        int row = orderReturnApplyMapper.deleteByPrimaryKey(id);
        Preconditions.checkArgument(row > 0, "删除申请失败");
    }

    public List<OrderReturnApply> list(Integer auditStatus, Integer pageNum, Integer pageSize) {

        return orderReturnApplyMapper.list(auditStatus, (pageNum-1)*pageSize, pageSize);
    }

    public void changeAuditStatus(Integer id, String auditWhy, String comment, Integer auditStatus) {
        OrderReturnApply orderReturnApply = new OrderReturnApply();
        orderReturnApply.setId(id);
        orderReturnApply.setAuditStatus(auditStatus);
        orderReturnApply.setAuditWhy(auditWhy);
        orderReturnApply.setAuditTime(new Date());
        orderReturnApply.setComment(comment);

        int row = orderReturnApplyMapper.updateByPrimaryKeySelective(orderReturnApply);
        Preconditions.checkArgument(row > 0, "更新状态失败");
    }

    public void refuse(Integer id, String auditWhy, String comment) {
        changeAuditStatus(id, auditWhy, comment, OrderConst.OrderReturnApplyEnum.REFUSE.getCode());
    }

    public void pass(Integer id, String auditWhy, String comment) {
        changeAuditStatus(id, auditWhy, comment, OrderConst.OrderReturnApplyEnum.PASS.getCode());
        OrderReturnApply orderReturnApply = orderReturnApplyMapper.selectByPrimaryKey(id);
        Preconditions.checkArgument(orderReturnApply != null, "id错误，没有相关的退单申请");
        cancel(orderReturnApply.getUserId(), orderReturnApply.getOrderNo());

    }

    private void cancel(Integer userId, Long orderNo) {
        Order order = orderMapper.selectByUserIdAndOrderNo(userId, orderNo);
        Preconditions.checkArgument(order!=null, "该用户的改订单不存在");
        Preconditions.checkArgument(order.getStatus() != OrderConst.OrderStatusEnum.SIGN.getCode(),
                "该订单已签收，无法取消");
        Order updateOrder = new Order();
        updateOrder.setId(order.getId());
        updateOrder.setStatus(OrderConst.OrderStatusEnum.CANCELED.getCode());
        int row = orderMapper.updateByPrimaryKeySelective(updateOrder);
        Preconditions.checkArgument(row>0, "取消订单失败");
    }



}
