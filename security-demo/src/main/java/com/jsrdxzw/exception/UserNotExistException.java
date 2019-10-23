package com.jsrdxzw.exception;

/**
 * @Author: xuzhiwei
 * @Date: 2019/10/23
 * @Description:
 */
public class UserNotExistException extends RuntimeException {
    private long id;

    public UserNotExistException() {
        super("user not exist");
    }

    public UserNotExistException(String message, long id) {
        super(message);
        this.id = id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
