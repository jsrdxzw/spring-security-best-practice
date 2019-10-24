package com.jsrdxzw.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.jsrdxzw.dto.User;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xuzhiwei
 * @Date: 2019/10/19
 * @Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 不返回密码
     *
     * @param username
     * @return
     */
    @GetMapping
    @JsonView(User.UserSimpleView.class)
    public List<User> queryUser(@RequestParam String username) {
        List<User> users = new ArrayList<>(3);
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

    /**
     * 限制接受数字
     * 返回密码
     *
     * @param id
     * @return
     */
    @GetMapping("/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User getInfo(@PathVariable String id) {
//        throw new UserNotExistException("not found", Long.parseLong(id));
        User user = new User();
        user.setUsername("tom");
        return user;
    }

    /**
     * @param user   前端传来的参数，转化为user对象
     * @param errors 参数信息错误处理
     * @return 创建后的user
     */
    @PostMapping
    public User createUser(@Valid @RequestBody User user, BindingResult errors) {
        if (errors.hasErrors()) {
            errors.getAllErrors().forEach(error -> System.out.println(error.getDefaultMessage()));
        }
        user.setId(1);
        return user;
    }

    @PutMapping("/{id:\\d+}")
    public User updateUser(@Valid @RequestBody User user, @PathVariable long id, BindingResult errors) {
        if (errors.hasErrors()) {
            errors.getAllErrors().forEach(error -> System.out.println(error.getDefaultMessage()));
        }
        user.setId(1);
        return user;
    }

    @DeleteMapping("/{id:\\d+}")
    public void delete(@PathVariable String id) {
        System.out.println(id);
    }
}
