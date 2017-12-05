package com.layout.controller;

import com.google.gson.Gson;
import com.layout.service.LayoutService;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by cq
 * date: 12/4 0004
 */
@Controller
@RequestMapping("approval")
public class LayoutController {

    @Autowired
    LayoutService service;

    Logger logger =  LoggerFactory.getLogger(LayoutController.class);
    /**
     * 获得前端对象
     * @param request
     * @return
     */
    //http://10.100.250.22:8555/tanent_search
    @RequestMapping("get/{id}")
    @ResponseBody
    public Object getLayoutObjects(HttpServletRequest request, @PathVariable String id) {
        String ip = "http://10.100.250.22:8555";
        String result = service.getLayoutObjects(ip,id);
        return result;
    }

    /**
     * 获得特定对象布局
     * @param request
     * @return
     */
    //http://10.100.250.22:8555/get_config?id=AQACd5VVkc7RCAAAAMXO4xQc5BQdCAAA&objName=Product
    @RequestMapping("get/{id}/{objName}")
    @ResponseBody
    public Object getLayoutObject(HttpServletRequest request,@RequestParam String id, @RequestParam String objName) {
        String ip = "http://10.100.250.22:8555";
        String result = service.getLayoutObject(ip,id,objName);
        return result;
    }


}
