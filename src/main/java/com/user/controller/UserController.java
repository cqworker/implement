package com.user.controller;

import com.google.gson.JsonParser;
import com.user.entity.User;
import com.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * Created by cq
 * date: 12/4 0004
 */

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService service;


    @RequestMapping("toLogin")
    @ResponseBody
    public ModelAndView toLogin() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user/login");
        return mv;
    }

    /**
     * 登录验证
     * @param map
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ModelAndView getUsers(@RequestParam Map map) {
        String json = service.login(map);
        int code = new JsonParser().parse(json).getAsJsonObject().get("code").getAsInt();
        if(code==0){
            return new ModelAndView("/home");
        }else{
            return new ModelAndView("/error");
        }

    }


    /**
     * 注册
     * @param map
     * @return
     */
    @RequestMapping(value = "register", method = RequestMethod.POST)
    @ResponseBody
    public Object register(@RequestParam Map map) {
        System.out.println(map);
        String json = service.register(map);
        return json;
    }

    /**
     * 获得所有user
     *
     * @return
     */
    @RequestMapping("get/list")
    @ResponseBody
    public Object getUsers() {
        List<User> dataList = service.getUsers();
        return dataList;
    }

    /**
     * 获得用户信息
     * @param userName
     * @return
     */
    @RequestMapping("get/{userName}")
    @ResponseBody
    public Object getUsers(@PathVariable String userName) {
        User user = service.findByUserName(userName);
        return user;
    }
}

