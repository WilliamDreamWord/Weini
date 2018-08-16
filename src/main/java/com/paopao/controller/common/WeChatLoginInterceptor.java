package com.paopao.controller.common;

import com.paopao.common.Const;
import com.paopao.common.JsonResponse;
import com.paopao.po.WeChatUser;
import com.paopao.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Method;

/**
 * Created by joker on 16/08/2018.
 */
public class WeChatLoginInterceptor extends HandlerInterceptorAdapter {

    private static Logger log = LoggerFactory.getLogger(WeChatLoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Class<?> targetClazz = handlerMethod.getBeanType();
        Method targetMethod = handlerMethod.getMethod();

        log.debug(" {} => 拦截Controller：{}, 拦截方法：{}  ", this.getClass().getName(), targetClazz, targetMethod);

        WeChatUser weChatUser = (WeChatUser) request.getSession().getAttribute(Const.CURRENT_WECHAT_USER_SESSION_KEY);
        if (weChatUser == null) {

            response.reset();// 这里要添加reset，否则报异常 getWriter() has already been called for this response.
            response.setCharacterEncoding("UTF-8");// 这里要设置编码，否则会乱码
            response.setContentType("application/json;charset=UTF-8");// 这里要设置返回值的类型，因为全部是json接口。
            PrintWriter out = response.getWriter();

            out.write(JsonUtil.obj2String(JsonResponse.createByErrorMsg("拦截器拦截,用户未登录")));

            out.flush();
            out.close();
            return false;
        }

        return true;

    }
}
