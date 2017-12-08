package com.meta.controller;

import com.google.gson.*;
import com.jayway.jsonpath.JsonPath;
import com.meta.service.MetaService;
import net.minidev.json.JSONObject;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
 * date: 11/15 0015 10:00
 */
@RequestMapping("meta")
@Controller
public class MetaController {
    @Autowired
    private MetaService service;

    Log log = LogFactory.getLog(MetaController.class);

    @RequestMapping("init")
    public String goMeta() {
        return "meta/init";
    }

    /**
     * @param request
     * @return 对象列表
     */
    @RequestMapping("get/list")
    @ResponseBody
    public String getALLMeta(HttpServletRequest request) {
        String ip = request.getSession().getAttribute("ip") + ":7010";
        String tenement = (String) request.getSession().getAttribute("tenement");
        String token = (String) request.getSession().getAttribute("token");
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
    @RequestMapping("post/{meta}")
    @ResponseBody
    public Object addMeta(HttpServletRequest request, @RequestParam Map map, @PathVariable String meta) {
        //System.out.println(map);//两个参数
        String ip = request.getSession().getAttribute("ip") + ":7020";
        String tenement = (String) request.getSession().getAttribute("tenement");
        String token = (String) request.getSession().getAttribute("token");
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), new Gson().toJson(map));
        String json = service.addMeta(requestBody, ip, tenement, meta, token);
        return json;
    }

    /**
     * 删除单个meta
     */
    @RequestMapping("delete/{meta}")
    @ResponseBody
    public Object deleteMetas(HttpServletRequest request, @PathVariable String meta) {
        String ip = request.getSession().getAttribute("ip") + ":7020";
        String tenement = (String) request.getSession().getAttribute("tenement");
        String token = (String) request.getSession().getAttribute("token");
        String json = service.deleteMeta(ip, tenement, meta, token);
        return json;
    }

    /**
     * 获得meta详情
     *
     * @param meta
     * @return
     */

    @RequestMapping("get/{meta}")
    public ModelAndView getMeta(HttpServletRequest request, @PathVariable("meta") String meta) {
        String ip = request.getSession().getAttribute("ip") + ":7010";
        String tenement = (String) request.getSession().getAttribute("tenement");
        String token = (String) request.getSession().getAttribute("token");
        List list = service.getMeta(ip, tenement, meta, token);
        log.info(list);
        Map map = new HashMap();
        map.put("list", list);
        return new ModelAndView("/meta/detail2", map);
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
    public Object addMetaSchema(HttpServletRequest request, @PathVariable String meta, @RequestParam Map map) {
        String ip = request.getSession().getAttribute("ip") + ":7020";
        String tenement = (String) request.getSession().getAttribute("tenement");
        String token = (String) request.getSession().getAttribute("token");

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), new Gson().toJson(map));
        String json = service.addMetaSchema(requestBody, ip, tenement, meta, token);
        return json;
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
    @RequestMapping("put/{meta}/schema")
    @ResponseBody
    public Object addField(HttpServletRequest request, @RequestParam Map map, @PathVariable String meta) {
        System.out.println("editmetasc");
        String ip = (String) request.getSession().getAttribute("ip") + ":7020";
        String tenement = (String) request.getSession().getAttribute("tenement");
        String token = (String) request.getSession().getAttribute("token");
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), new Gson().toJson(map));
        String json = service.editMetaSchema(requestBody, ip, tenement, meta, token);
        return json;
    }

    /**
     * 删除 Meta字段
     *
     * @return
     */
    //api/v1.0/meiqia/car/meta/drop
    @RequestMapping("delete/schema")
    public Object deleteMeta(HttpServletRequest request, @RequestParam String ids) {
        String ip = request.getSession().getAttribute("ip") + ":7020";
        String tenement = (String) request.getSession().getAttribute("tenement");
        String token = (String) request.getSession().getAttribute("token");
        JsonArray idsArray = new JsonParser().parse(ids).getAsJsonArray();
        String meta = "";
        String json ="";
        for (JsonElement el : idsArray) {
            meta = el.getAsString();
            System.out.println(el.toString());
            Map map = new HashMap();
            map.put("name",meta);
            RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), new Gson().toJson(map));
           json = service.deleteMetaSchema(requestBody, ip, tenement, meta, token);
        }
        return json;
    }

}




