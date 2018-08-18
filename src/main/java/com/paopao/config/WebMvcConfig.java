package com.paopao.config;


import com.paopao.controller.common.LoginInterceptor;
import com.paopao.controller.common.WeChatLoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {



    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
        registry.addResourceHandler("/statics/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/mappers/**").addResourceLocations("classpath:/mappers/");
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/manager/**").excludePathPatterns("/manager/user/login.do")
                .excludePathPatterns("/manager/user/register.do");

        registry.addInterceptor(new WeChatLoginInterceptor())
                .addPathPatterns("/wechat/**").excludePathPatterns("/wechat/user/login.do");

    }
}
