package com.paopao.controller.common;

import com.paopao.po.WeChatUser;
import org.springframework.stereotype.Component;

/**
 * Created by joker on 11/08/2018.
 */
@Component
public class HostHolder {

    private static ThreadLocal<WeChatUser> weChatUserThreadLocal = new ThreadLocal<>();

    public WeChatUser getWeChatUser() {
        return weChatUserThreadLocal.get();
    }

    public void setWechatUser(WeChatUser user) {
        weChatUserThreadLocal.set(user);
    }

    public void clear() {
        weChatUserThreadLocal.remove();
    }

}
