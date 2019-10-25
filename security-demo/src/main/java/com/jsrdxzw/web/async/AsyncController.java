package com.jsrdxzw.web.async;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @Author: xuzhiwei
 * @Date: 2019/10/25
 * @Description:
 */
@RestController
public class AsyncController {

    private final MockQueue mockQueue;

    private final DeferredResultHolder deferredResultHolder;

    public AsyncController(MockQueue mockQueue, DeferredResultHolder deferredResultHolder) {
        this.mockQueue = mockQueue;
        this.deferredResultHolder = deferredResultHolder;
    }

    @RequestMapping("/order")
    public DeferredResult<String> order() throws InterruptedException {
        String orderNumber = RandomStringUtils.random(8);
        mockQueue.setPlaceOrder(orderNumber);
        DeferredResult<String> result = new DeferredResult<>();
        deferredResultHolder.getMap().put(orderNumber, result);
        return result;
    }
}
