package com.trigger.controller;

import com.trigger.service.TriggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping("get/{tenement}/{meta}")
    public ModelAndView getTrigger(HttpServletRequest request, @PathVariable String tenement, @PathVariable String meta) {
        String ip = (String) request.getSession().getServletContext().getAttribute("ip");
        Map<String, String> dataMap = service.getTrigger(ip, tenement, meta);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/trigger");
        mv.addObject(dataMap);
        return mv;
    }

    @RequestMapping(value = {"post/{tenement}/{meta}","put/{tenement}/{meta}"})
    public ModelAndView addTrigger(HttpServletRequest request, @PathVariable String tenement, @PathVariable String meta,Map map) {
        String ip = (String) request.getSession().getServletContext().getAttribute("ip");
        Map<String, String> dataMap = service.addTrigger(ip, tenement, meta,map);
        //json
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/trigger");
        mv.addObject(dataMap);
        return mv;
    }


}
