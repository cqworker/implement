package com.meta.controller;

import com.google.gson.*;
import com.jayway.jsonpath.JsonPath;
import com.meta.service.MetaService;
import net.minidev.json.JSONObject;
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
import java.util.List;
import java.util.Map;

/**
 * Created by cq
 * date: 11/15 0015 10:00
 */
@RequestMapping("meta")
@Controller
public class MetaController {
    @Autowired
    private MetaService service;


    @RequestMapping("init")
    public String goMeta() {
        return "meta";
    }

    // TODO
    @RequestMapping("get/111")
    @ResponseBody
    public Object get111() {
        System.out.println("getsuccess");
        String token = "AQsCAH4ZylkAAEFRQUNkNVZWa2M3UkNBQUFQU0xlNHhRYzVCUWVDQUFBQVFBQ2Q1VlZrYzdSQ0FBQUFNWE80eFFjNUJRZENBQUHpdByJItptku7_xrJZvPRPvw8ETwX8c74DTTHaq5ClR2ouJbEKqLDInLz-P_KmENSsJMTtcrOe0pjlIlTItpid";
        List list = service.getMeta("10.100.250.133:7010", "GuoXinLianCheng", "Contract", token);
        String s = new Gson().toJson(list);


        return list;
    }
    /**
     * @param request
     * @return 对象列表
     */
    @RequestMapping("get/list")
    @ResponseBody
    public String getALLMeta(HttpServletRequest request) {
        System.out.println("metaList");
        String ip = (String) request.getSession().getAttribute("ip")+":7010";
        String tenement = (String) request.getSession().getAttribute("tenement");
        String token = (String) request.getSession().getAttribute("token");
        System.out.println(ip+"---"+tenement);
        String json = service.getAllMeta(ip, tenement, token);
        return json;
    }

    /**
     * 创建对象
     *
     * @param request
     * @param map
     * @return 新创建对象
     */
    @RequestMapping("post/meta")
    @ResponseBody
    public Object addMeta(HttpServletRequest request, @RequestParam Map map) {
        System.out.println("addmeta");
        String ip =  request.getSession().getAttribute("ip")+":7020";
        String tenement = (String) request.getSession().getAttribute("tenement");
        String token = (String) request.getSession().getAttribute("token");
        String meta = (String) map.get("meta");
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), new Gson().toJson(map));
        Integer code = service.addMeta(requestBody, ip, tenement, meta, token);
        //TODO
        return null;
    }

    /**
     * 删除单个meta
     */
    @RequestMapping("delete/meta")
    @ResponseBody
    public Object deleteMetas(HttpServletRequest request, @RequestParam Map map) {
        System.out.println("deltetemeta");
        String ip = (String) request.getSession().getAttribute("ip")+":7020";
        String tenement = (String) request.getSession().getAttribute("tenement");
        String token = (String) request.getSession().getAttribute("token");
        String meta = (String) map.get("meta");
        Integer code = service.deleteMeta(ip, tenement, meta, token);
        //TODO
        System.out.println(code);
        return code;
    }

    /**
     * 获得meta详情
     *
     * @param meta
     * @return
     */

    @RequestMapping("get/{meta}")
    @ResponseBody
    public Object getMeta(HttpServletRequest request, @PathVariable("meta") String meta) {
        System.out.println("getmeta");
        String ip = (String) request.getSession().getAttribute("ip")+":7010";
        String tenement = (String) request.getSession().getAttribute("tenement");
        String token = (String) request.getSession().getAttribute("token");
        System.out.println("get"+ip+tenement+"success");
        List list = service.getMeta(ip, tenement, meta, token);
        return list;
    }



    /**
     * 创建meta字段/新增一列
     *
     * @param request
     * @param meta
     * @param map
     * @return
     */
    //meta详情页面点击新增
    @RequestMapping("post/schema")
    public Object addMetaSchema(HttpServletRequest request, @PathVariable String meta, Map map) {
        System.out.println("addmetaschema");
        String ip = (String) request.getSession().getAttribute("ip")+":7020";
        String tenement = (String) request.getSession().getAttribute("tenement");
        String token = (String) request.getSession().getAttribute("token");

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), new Gson().toJson(map));
        Integer code = service.addMetaSchema(requestBody, ip, tenement, meta, token);
        //TODO
        return null;
    }


    /**
     * 修改 Schema
     * 修改display_name/description
     *
     * @return
     */
    @RequestMapping("put/{meta}")
    public Object editMeta(HttpServletRequest request, @PathVariable String meta, Map map) {
        return null;
    }

    /**
     * 修改Meta 字段
     *
     * @param request
     * @param map
     * @return
     */
    @RequestMapping("put/schema")
    public Object addField(HttpServletRequest request, @RequestParam Map map) {
        System.out.println("editmetasc");
        String ip = (String) request.getSession().getAttribute("ip")+":7020";
        String tenement = (String) request.getSession().getAttribute("tenement");
        String token = (String) request.getSession().getAttribute("token");
        String meta = (String) map.get("meta");
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), new Gson().toJson(map));
        Integer code = service.editMetaSchema(requestBody, ip, tenement, meta, token);

        return null;
    }

    /**
     * 删除 Meta字段
     *
     * @return
     */
    //api/v1.0/meiqia/car/meta/drop
    @RequestMapping("delete/schema")
    public Object deleteMeta(HttpServletRequest request, @RequestParam Map map) {
        System.out.println("deletemetasc");
        String ip = (String) request.getSession().getAttribute("ip")+":7020";
        String tenement = (String) request.getSession().getAttribute("tenement");
        String token = (String) request.getSession().getAttribute("token");
        String meta = (String) map.get("meta");
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), new Gson().toJson(map));
        Integer code = service.deleteMetaSchema(requestBody, ip, tenement, meta, token);
        //TODO
        return null;
    }

}




