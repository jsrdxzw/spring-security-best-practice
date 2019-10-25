package com.jsrdxzw.web.async;

import org.springframework.stereotype.Component;

/**
 * @Author: xuzhiwei
 * @Date: 2019/10/24
 * @Description:
 */
@Component
public class MockQueue {
    private String placeOrder;
    private String completeOrder;

    public String getPlaceOrder() {
        return placeOrder;
    }

    public void setPlaceOrder(String placeOrder) throws InterruptedException {
        System.out.println("接到下单请求");
        Thread.sleep(1000);
        this.completeOrder = placeOrder;
        System.out.println("下单请求处理完毕" + placeOrder);
    }

    public String getCompleteOrder() {
        return completeOrder;
    }

    public void setCompleteOrder(String completeOrder) {
        this.completeOrder = completeOrder;
    }
}
