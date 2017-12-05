package com.validation.controller;

import com.google.gson.Gson;
import com.validation.service.ValidationService;
import com.validation.service.ValidationServiceImpl;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cq
 * date: 11/21 0021
 */
@Controller
@RequestMapping("validation")
public class ValidationController {

    @Autowired
    ValidationService service;

    @RequestMapping("get/{meta}")
    public ModelAndView getValidations(HttpServletRequest request,@PathVariable String meta) {
        String ip =  request.getSession().getAttribute("ip")+":7020";
        String token = (String) request.getSession().getAttribute("token");
        String tenement = (String) request.getSession().getAttribute("name");
        List<String> list = service.getList(ip, tenement, meta,token);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("/validationList");
        mv.addObject("list", list);
        return mv;
    }

    /**
     * 添加validation
     * @param request
     * @param map
     * @return
     */
    @RequestMapping("post/{meta}")
    @ResponseBody
    public Object addValidation(HttpServletRequest request, @RequestParam Map map,@PathVariable String meta) {
        String ip =  request.getSession().getAttribute("ip")+":7020";
        String tenement = (String) request.getSession().getAttribute("name");
        String token = (String) request.getSession().getAttribute("token");

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), new Gson().toJson(map));
        Integer code = service.addValidation(requestBody,ip, tenement, meta);
        Map<String,String> dataMap = new HashMap();
        if(code==0){
            dataMap.put("result","success");
            dataMap.put("message","");
        }else{

        }
        return new Gson().toJson(dataMap);
    }

    /**
     * 获取指定 Validation
     * @param request
     * @return
     */
    @RequestMapping("get/{meta}/{validation_name}")
    public ModelAndView getValidation(HttpServletRequest request,@PathVariable String meta,@PathVariable String validation_name) {
        String ip = request.getSession().getAttribute("ip")+":7020";
        String tenement = (String) request.getSession().getAttribute("name");
        String token = (String) request.getSession().getAttribute("token");

        String validation = service.getValidation(ip, tenement, meta, validation_name,token);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/validation/detail");
        mv.addObject("validation", validation);
        return mv;
    }

    /**
     * 删除指定validation
     * @param request
     * @return
     */
    @RequestMapping("delete/{meta}/{validation_name}")
    @ResponseBody
    public Object deleteOneValidation(HttpServletRequest request,@PathVariable String meta,@PathVariable String validation_name) {
        String ip =  request.getSession().getAttribute("ip")+":7020";
        String tenement = (String) request.getSession().getAttribute("name");
        String token = (String) request.getSession().getAttribute("token");

        Integer code = service.deleteValidation(ip, tenement, meta, validation_name,token);
        Map<String,String> dataMap = new HashMap();
        if(code==0){
            dataMap.put("result","success");
            dataMap.put("message","");
        }else{

        }
        return new Gson().toJson(dataMap);
    }

    /**
     * 修改
     * @param request
     * @param validation_name
     * @param map
     * @return
     */

    @RequestMapping("put/{meta}/{validation_name}")
    @ResponseBody
    public Object putOneValidation(HttpServletRequest request, @RequestParam Map map,@PathVariable String validation_name,@PathVariable String meta) {
        String ip = request.getSession().getAttribute("ip")+":7020";
        String tenement = (String) request.getSession().getAttribute("name");
        String token = (String) request.getSession().getAttribute("token");
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), new Gson().toJson(map));

        Integer code = service.editValidation(requestBody ,ip, tenement, meta, validation_name,token);
        Map<String,String> dataMap = new HashMap();
        if(code==0){
            dataMap.put("result","success");
            dataMap.put("message","");
        }else{

        }
        return new Gson().toJson(dataMap);
    }

    /**
     * 启用validation
     * @param request
     * @param meta
     * @param validation_name
     * @return
     */
    @RequestMapping("open/{meta}/{validation_name}")
    public ModelAndView openOneValidation(HttpServletRequest request, @PathVariable String meta, @PathVariable String validation_name) {
        String ip = (String) request.getSession().getAttribute("ip");
        String tenement = (String) request.getSession().getAttribute("name");
        String token = (String) request.getSession().getAttribute("token");
        Integer code = service.openValidation(ip, tenement, meta, validation_name,token);

       // TODO
        return null;
    }

    // 关闭
    @RequestMapping("close/{meta}/{validation_name}")
    public ModelAndView closeOneValidation(HttpServletRequest request, @PathVariable String meta, @PathVariable String validation_name) {
        String ip = (String) request.getSession().getAttribute("ip");
        String tenement = (String) request.getSession().getAttribute("name");
        String token = (String) request.getSession().getAttribute("token");
        Integer code = service.closeOneValidation(ip, tenement, meta, validation_name,token);

        ModelAndView mv = new ModelAndView();
        // TODO
        return null;
    }
}
