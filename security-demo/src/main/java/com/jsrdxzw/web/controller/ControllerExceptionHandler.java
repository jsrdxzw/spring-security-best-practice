package com.jsrdxzw.web.controller;

import com.jsrdxzw.exception.UserNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xuzhiwei
 * @Date: 2019/10/23
 * @Description:
 */
@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(UserNotExistException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> handlerUserNotExistException(UserNotExistException ex) {
        Map<String, Object> result = new HashMap<>(2);
        result.put("id", ex.getId());
        result.put("message", ex.getMessage());
        return result;
    }
}
