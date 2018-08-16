package com.paopao.common;

/**
 * Created by joker on 11/08/2018.
 */
public class Const {

    public static final String CURRENT_MANAGER_USER = "CURRRENT_MANAGER_USER";
    public static final String CURRENT_WECHAT_USER_SESSION_KEY = "CURRENT_WECHAT_USER_SESSION_KEY";
    public static final String CURRENT_WECHAT_USER_OPEN_ID = "CURRENT_WECHAT_USER_OPEN_ID";
    public static final String CURRENT_WECHAT_USER = "CURRENT_WECHAT_USER";

    public enum Role {
        ADMIN(2, "管理员"),
        NORMAL(1, "普通用户");

        private int code;
        private String val;

        public int getCode() {
            return code;
        }


        public String getVal() {
            return val;
        }


        Role(int code, String val) {
            this.code = code;
            this.val = val;
        }

        public static Role codeOf(int code) {
            for (Role role : values()) {
                if (role.getCode() == code) {
                    return role;
                }
            }
            throw new RuntimeException("没有找到对应的枚举");
        }
    }

    public interface RedisCacheExtime {
        int REDIS_SESSION_EXTIME = 60*30;
    }

    public enum PackageType {
        SMALL(1, "小件"),
        LARGE(2, "大件"),
        SUPER_HUGE(3, "超大件");


        private int code;
        private String val;

        PackageType(int code, String val) {
            this.code = code;
            this.val = val;
        }

        public int getCode() {
            return code;
        }

        public String getVal() {
            return val;
        }

        public static PackageType codeOf(int code) {
            for (PackageType packageType : values()) {
                if (packageType.getCode() == code) {
                    return packageType;
                }
            }
            throw new RuntimeException("没有找到对应的枚举");
        }

    }

    public enum PackageStatus {
        WAIT(1, "等待"),              //未添加订单
        DISPATCH(2, "分派"),         //添加订单成功
        CANCEL(3, "取消");

        PackageStatus(int code, String value) {
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

        public static PackageStatus codeOf(int code) {
            for (PackageStatus orderStatusEnum : values()) {
                if (orderStatusEnum.getCode() == code) {
                    return orderStatusEnum;
                }
            }
            throw new RuntimeException("没有找到对应的枚举");
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
            throw new RuntimeException("没有找到对应的枚举");
        }
    }


    public enum WeChatIdentity {
        NORMAL(1, "普通用户"),
        VIP(2, "VIP");

        WeChatIdentity(int code, String value) {
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

        public static WeChatIdentity codeOf(int code) {
            for (WeChatIdentity weChatIdentity : values()) {
                if (weChatIdentity.getCode() == code) {
                    return weChatIdentity;
                }
            }
            throw new RuntimeException("没有找到对应的枚举");
        }

    }

}
