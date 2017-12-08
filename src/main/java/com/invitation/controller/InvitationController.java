package com.invitation.controller;

import com.google.gson.Gson;
import com.invitation.service.InvitationService;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by cq
 * date: 11/26 0026
 */
@Controller
@RequestMapping("invitation")
public class InvitationController {

    @Autowired
    InvitationService service;

    //点击导航栏跳转页面
    @RequestMapping("init")
    public String goMeta() {
        return "invitation";
    }

    @RequestMapping("post")
    @ResponseBody
    //异步展示是否邀请成功
    public Object invitation(HttpServletRequest request, @RequestParam Map map) {
        String ip = request.getSession().getAttribute("ip") + ":7121";
        String token = (String) request.getSession().getAttribute("token");
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), new Gson().toJson(map));
        String json = service.invitation(requestBody, ip, token);
        return json;
    }

}
