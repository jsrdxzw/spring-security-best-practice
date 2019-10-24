package com.jsrdxzw.web.interceptor;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: xuzhiwei
 * @Date: 2019/10/23
 * @Description: 性能上不如Spring AOP
 */
//@Component
public class TimeInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("pre handle");
        System.out.println(((HandlerMethod) handler).getBean().getClass().getName());
        System.out.println(((HandlerMethod) handler).getMethod().getName());

        request.setAttribute("startTime", System.currentTimeMillis());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("post handle");
        long startTime = (long) request.getAttribute("startTime");
        System.out.println("time interceptor 耗时:" + (System.currentTimeMillis() - startTime));
    }

    /**
     * 无论是正常返回还是抛出异常，都会执行
     * 但是如果我们已经自定义捕获我们的自定义异常，如RestControllerAdvice，则获取ex为空
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("after handle");
        long startTime = (long) request.getAttribute("startTime");
        System.out.println("time interceptor 耗时:" + (System.currentTimeMillis() - startTime));
        System.out.println("ex is:" + ex);
    }
}
