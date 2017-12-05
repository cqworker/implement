package com.cache;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by cq
 * date: 11/20 0020
 */
@RequestMapping("cache")
@Controller
public class CacheController {
    /**
     * @param request
     * @return
     */
    //初始化界面点击设置
    @RequestMapping("post")
    public String setCache(HttpServletRequest request){
        String tenementName = request.getParameter("tenementName");
        String ip = request.getParameter("ip");
        String token = request.getParameter("token");
        HttpSession session = request.getSession();
        session.setAttribute("ip",ip);
        session.setAttribute("token",token);
        System.out.println("setCache"+ip+tenementName+"success");
        if(tenementName==null||tenementName.trim().equals("")){
            //TODO 查询数据库是否存在租户-->不存在-->跳转到新建租户页面
         return "tenement";
        }else {
            //租户已存在
            session.setAttribute("tenement", tenementName);
            //redirect:meta --cache/meta
            //return "/meta";
            return "/meta2";
        }
    }
    //TODO grpc查询该环境下所有租户,根据选择的租户进行缓存操作
}
