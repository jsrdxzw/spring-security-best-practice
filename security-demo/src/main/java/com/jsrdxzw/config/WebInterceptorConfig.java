package com.jsrdxzw.config;

import com.jsrdxzw.web.interceptor.TimeInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: xuzhiwei
 * @Date: 2019/10/23
 * @Description:
 */
@Configuration
public class WebInterceptorConfig implements WebMvcConfigurer {
    private final TimeInterceptor timeInterceptor;

    public WebInterceptorConfig(TimeInterceptor timeInterceptor) {
        this.timeInterceptor = timeInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(timeInterceptor);
    }
}
