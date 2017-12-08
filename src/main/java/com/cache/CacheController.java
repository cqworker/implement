package com.cache;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by cq
 * date: 11/20 0020
 */
@RequestMapping("cache")
@Controller
public class CacheController {
    /**实施信息配置
     * @param request
     * @return
     */
    //初始化界面点击设置
    @RequestMapping("post")
    public String setCache(HttpServletRequest request) {
        //todo 查出所有租户
        String tenementName = request.getParameter("tenementName");
        String ip = request.getParameter("ip");
        //TODO　自动获取token
        String token = request.getParameter("token");
        HttpSession session = request.getSession();
        session.setAttribute("ip", ip);
        session.setAttribute("token", token);
        System.out.println("setCache" + ip + tenementName + "success");
        if (tenementName == null || tenementName.trim().equals("")) {
            //TODO 查询数据库是否存在租户-->不存在-->跳转到新建租户页面
            return "tenement";
        } else {
            //租户已存在
            session.setAttribute("tenement", tenementName);
            //redirect:meta --cache/meta
            //return "/meta";
            return "/meta/meta2";
        }
    }
    //TODO grpc查询该环境下所有租户,根据选择的租户进行缓存操作

    /**
     * 外链获取token
     *
     * @param request
     * @return
     */
    @RequestMapping("config")
    @ResponseBody
    public Object getConfig(HttpServletRequest request) {
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");

        String token = "";
        return new Gson().toJson(token);
    }

    /**
     * 登录成功跳转到初始化页面
     * @return
     */
    @RequestMapping("init")
    public String init() {
        return "/init";
    }

}
