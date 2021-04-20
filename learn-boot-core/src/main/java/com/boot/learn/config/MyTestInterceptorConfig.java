package com.boot.learn.config;

import com.boot.learn.service.Interceptor.MyTestInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author: yeguxin
 * @date: 2021/4/20
 * @description:
 */
@Configuration
public class MyTestInterceptorConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyTestInterceptor()).addPathPatterns("/boot/test/listener");
        super.addInterceptors(registry);
    }
}
