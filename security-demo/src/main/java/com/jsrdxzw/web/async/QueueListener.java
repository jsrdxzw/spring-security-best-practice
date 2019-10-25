package com.jsrdxzw.web.async;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @Author: xuzhiwei
 * @Date: 2019/10/25
 * @Description: Spring 生命周期监听器
 */
@Component
@Slf4j
public class QueueListener implements ApplicationListener<ContextRefreshedEvent> {

    private final MockQueue mockQueue;

    private final DeferredResultHolder deferredResultHolder;

    public QueueListener(MockQueue mockQueue, DeferredResultHolder deferredResultHolder) {
        this.mockQueue = mockQueue;
        this.deferredResultHolder = deferredResultHolder;
    }

    // 应用启动
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        new Thread(() -> {
            while (true) {
                if (StringUtils.isNotBlank(mockQueue.getCompleteOrder())) {
                    String completeOrder = mockQueue.getCompleteOrder();
                    log.info("返回订单处理结果:{}", completeOrder);
                    deferredResultHolder.getMap().get(completeOrder).setResult("place order success");
                    mockQueue.setCompleteOrder(null);
                } else {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
