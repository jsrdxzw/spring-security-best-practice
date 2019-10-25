package com.jsrdxzw.config;

import com.jsrdxzw.web.interceptor.TimeInterceptor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: xuzhiwei
 * @Date: 2019/10/23
 * @Description:
 */
//@Configuration
public class WebInterceptorConfig implements WebMvcConfigurer {
    private final TimeInterceptor timeInterceptor;

    public WebInterceptorConfig(TimeInterceptor timeInterceptor) {
        this.timeInterceptor = timeInterceptor;
    }


    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        // 注册异步拦截器
        // configurer.registerDeferredResultInterceptors();
        // 设置异步线程池
        // configurer.setTaskExecutor()
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(timeInterceptor);
    }
}
