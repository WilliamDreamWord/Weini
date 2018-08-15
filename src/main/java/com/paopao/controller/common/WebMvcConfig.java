package com.paopao.controller.common;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {



    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/statics/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/mappers/**").addResourceLocations("classpath:/mappers/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/manager/**").excludePathPatterns("/manager/user/login.do")
                .excludePathPatterns("/manager/user/register.do");

    }
}
