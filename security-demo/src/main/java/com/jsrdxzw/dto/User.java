package com.jsrdxzw.dto;


import com.fasterxml.jackson.annotation.JsonView;
import com.jsrdxzw.validator.MyConstraint;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * @Author: xuzhiwei
 * @Date: 2019/10/19
 * @Description:
 */
public class User {

    /**
     * 总查询的时候不返回密码,名字任意
     */
    public interface UserSimpleView {
    }

    /**
     * 详情查询的时候返回用户密码
     */
    public interface UserDetailView extends UserSimpleView {
    }

    private long id;

    @MyConstraint(message = "自定义校验测试")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;

    /**
     * 前端传时间戳最好,这边传过来自动转化为Date格式
     * 生日必须是过去的时间
     */
    @Past(message = "生日必须是过去的时间")
    private Date birthday;

    @JsonView(UserSimpleView.class)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonView(UserDetailView.class)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonView(UserSimpleView.class)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @JsonView(UserSimpleView.class)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
