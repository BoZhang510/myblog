package com.xzhy.zhb.myblog.intercepter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassNameWebConfig
 * @Description TODO
 * @Author zhangb181
 * @Date2020/5/6 15:31
 * @Version V1.0
 **/
@Configuration
public class WebConfig implements WebMvcConfigurer
{
    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        InterceptorRegistration registration = registry.addInterceptor(new LoginInterceptor());
        registration.addPathPatterns("/admin/**");
        registration.excludePathPatterns("/admin","/admin/login","/static/**");
    }
}
