package com.trigger.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.meta.service.MetaService;
import com.trigger.service.TriggerService;
import com.util.api.HttpImpl;
import com.util.api.TriggerHttpApi;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by cq
 * date: 11/22 0022
 */
@Controller
@RequestMapping("trigger")
public class TriggerController {
    @Autowired
    TriggerService service;
    @Autowired
    MetaService metaService;

    Log log = LogFactory.getLog(TriggerController.class);


    /**
     *
     * @param request
     * @return
     */
    @RequestMapping("get/list")
    public ModelAndView getTriggerList(HttpServletRequest request) {
        String ip = request.getSession().getAttribute("ip") + ":7020";
        String token = (String) request.getSession().getAttribute("token");
        String tenement = (String) request.getSession().getAttribute("tenement");

        List<String> dataList = new ArrayList<>();
//      [{"name":"","display_name":""},{},{}]

        String allMeta = metaService.getAllMeta(ip, tenement, token);
        JsonArray asJsonArray = new JsonParser().parse(allMeta).getAsJsonArray();
        for (JsonElement el : asJsonArray) {
            String meta = el.getAsJsonObject().get("name").getAsString();
            String trigger = service.getTrigger(ip, tenement, meta, token);
//          #--这是trigger注释--
//            String[] diss = trigger.split("--");
//            for (int a = 0;a<diss.length;a++){
//                if(a/2 !=0){
//                    String dis =diss[a];
//                }
//            }
            //{success:"",body:""}
            dataList.add(trigger);
        }

        ModelAndView mv = new ModelAndView("/trigger/init");
        mv.addObject("list",dataList);
        return mv;
    }


    /**
     * 获得单个trigger
     *
     * @param request
     * @param meta
     * @return
     */
    @RequestMapping("get/{meta}")
    @ResponseBody
    public Object getTrigger(HttpServletRequest request, @PathVariable String meta) {
        String ip = request.getSession().getAttribute("ip") + ":7020";
        String token = (String) request.getSession().getAttribute("token");
        String tenement = (String) request.getSession().getAttribute("tenement");

        String json = service.getTrigger(ip, tenement, meta, token);
        log.info(json);
        // {success,body}
        return json;
    }

    /**
     * 添加trigger
     *
     * @param request
     * @param map
     * @return
     */
    @RequestMapping(value = {"post/{meta}", "put/{meta}"}, method = RequestMethod.POST)
    public String addTrigger(HttpServletRequest request, @PathVariable String meta, @RequestParam Map map) {
        String ip = request.getSession().getAttribute("ip") + ":7020";
        String tenement = (String) request.getSession().getAttribute("tenementName");
        String token = (String) request.getSession().getAttribute("token");
        String json = service.addTrigger(ip, tenement, meta, token, map);
        log.info(json);
        return json;
    }


}
