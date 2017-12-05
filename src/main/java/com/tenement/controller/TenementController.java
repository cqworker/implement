package com.tenement.controller;

import com.google.gson.Gson;
import com.tenement.service.TenementService;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author cq
 */
@RequestMapping("tenement")
@Controller
public class TenementController {
    @Autowired
    private TenementService service;

    @RequestMapping("init")
    public String goTenement() {
        return "tenement";
    }

    /**
     * 创建租户
     *
     * @param request
     * @param map
     * @return
     */
    //点击租户配置不存在租户/创建租户
    @RequestMapping("post")
    public ModelAndView addAccount(HttpServletRequest request, @RequestParam Map<String, String> map) {
        String phone = map.get("phone");
        if(phone!=null||phone.trim()!=""){
            map.remove("email");
        }else{
            map.remove("phone");
        }
        String ip = (String) request.getSession().getAttribute("ip");
        String token = (String) request.getSession().getAttribute("token");
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), new Gson().toJson(map));
        Integer code = service.addAccount(requestBody, ip, token);
       if(code==0){
           request.getSession().setAttribute("tenement",map.get("name"));
       }
       //TODO
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:meta/get/list");
        return modelAndView;
    }

    /**
     * 查看租户信息
     * @return
     */
    //https://crm.meiqia.com/tenant-gateway/tenant/org/AQACd5VVkc7RCAAAAMXO4xQc5BQdCAAA
    @RequestMapping("get/{id}")
    public Object getAccount(HttpServletRequest request,@PathVariable String id) {
        String ip = (String) request.getSession().getAttribute("ip");
        String token = (String) request.getSession().getAttribute("token");
        String data = service.getAccount( ip,id, token);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(data);
        modelAndView.setViewName("redirect:tenement/get/detail");
        return modelAndView;
    }

    @RequestMapping("delete")
    public Object deleteAccount() {

        return null;
    }
}
