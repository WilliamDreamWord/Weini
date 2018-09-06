package com.paopao.common;

/**
 * Created by joker on 06/09/2018.
 */
public class OrderConst {


    //0-取消包裹订单
    public enum OrderReturnApplyTypeEnum {
        PACKAGE(0, "取消包裹订单");

        OrderReturnApplyTypeEnum(int code, String value) {
            this.code = code;
            this.value = value;
        }

        private String value;
        private int code;


        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }

        public static OrderReturnApplyTypeEnum codeOf(int code) {
            for (OrderReturnApplyTypeEnum orderReturnApplyTypeEnum : values()) {
                if (orderReturnApplyTypeEnum.getCode() == code) {
                    return orderReturnApplyTypeEnum;
                }
            }
            return null;
        }

    }

    //审核状态 -1 拒绝 0 未审核 1 审核通过
    public enum OrderReturnApplyEnum {
        REFUSE(-1, "拒绝"),
        NON_AUDIT(0, "未审核"),
        PASS(1, "审核通过");

        OrderReturnApplyEnum(int code, String value) {
            this.code = code;
            this.value = value;
        }

        private String value;
        private int code;


        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }


    }


    //0-已取消，10-已下单，20-已接单，30-已签收
    public enum OrderStatusEnum{
        CANCELED(0, "已取消"),
        PUBLISH_ORDER(10, "已下单"),
        GET_ORDER(20, "已接单"),
        SIGN(30, "已签收");

        OrderStatusEnum(int code, String value) {
            this.code = code;
            this.value = value;
        }

        private String value;
        private int code;


        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }

        public static OrderStatusEnum codeOf(int code) {
            for (OrderStatusEnum orderStatusEnum : values()) {
                if (orderStatusEnum.getCode() == code) {
                    return orderStatusEnum;
                }
            }
            return null;
        }
    }

    public enum PaymentType {
        OFFLINE_PAY(1,"线下支付");


        private int code;
        private String val;

        PaymentType(int code, String val) {
            this.code = code;
            this.val = val;
        }

        public int getCode() {
            return code;
        }

        public String getVal() {
            return val;
        }

        public static PaymentType codeOf(int code) {
            for (PaymentType paymentType : values()) {
                if (paymentType.getCode() == code) {
                    return paymentType;
                }
            }
            throw new RuntimeException("没有找到对应的枚举");
        }

    }
}
