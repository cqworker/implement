package com.user.controller;

import com.user.entity.User;
import com.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by cq
 * date: 12/4 0004
 */

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService service;

    /**
     * 获得所有user
     *
     * @return
     */

    @RequestMapping("get/list")
    @ResponseBody
    public Object getUsers() {
        List<User> dataList = service.getUsers();
        return null;
    }


    @RequestMapping("get/{userName}")
    @ResponseBody
    public Object getUsers(@PathVariable String userName) {
        User user = service.getUserByUserName(userName);
        return null;
    }
}

