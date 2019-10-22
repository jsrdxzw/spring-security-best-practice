package com.jsrdxzw.service.impl;

import com.jsrdxzw.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * @Author: xuzhiwei
 * @Date: 2019/10/22
 * @Description:
 */
@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String greeting(String name) {
        return "greeting" + name;
    }
}
