package com.approve.controller;

import com.approve.service.ApprovalService;
import com.google.gson.Gson;
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
public class ApproveController {

    @Autowired
    ApprovalService service;

    Logger logger =  LoggerFactory.getLogger(ApproveController.class);
    /**
     * 获得meta的审批模板s
     * @param request
     * @param meta
     * @return
     */
    @RequestMapping("get/{meta}")
    @ResponseBody
    public Object getApprovals(HttpServletRequest request, @PathVariable String meta) {
        String ip =  request.getSession().getAttribute("ip")+":7010";
        String token = (String) request.getSession().getAttribute("token");
        String tenement = (String) request.getSession().getAttribute("tenementName");
        String result = service.getApprovals(tenement,ip, meta, token);
        return result;
    }

    /**
     * 创建审批
     * @param request
     * @return
     */
    @RequestMapping("add")
    @ResponseBody
    public Object addApproval(HttpServletRequest request, @RequestParam Map map) {
        String ip =  request.getSession().getAttribute("ip")+":7010";
        String token = (String) request.getSession().getAttribute("token");
        String tenement = (String) request.getSession().getAttribute("tenementName");
        //解析map
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), new Gson().toJson(map));
        System.out.println(requestBody);
        String result = service.addApproval(requestBody,tenement,ip,token);
        return result;
    }

    /**
     * 获得指定模板
     * @param request
     * @param template_id
     * @return
     */
    @RequestMapping("get/{template_id}")
    @ResponseBody
    public Object getApproval(HttpServletRequest request, @PathVariable String template_id) {
        String ip =  request.getSession().getAttribute("ip")+":7010";
        String token = (String) request.getSession().getAttribute("token");
        String tenement = (String) request.getSession().getAttribute("tenementName");
        String result = service.getApproval(tenement,template_id,ip,token);
        return result;
    }

    /**
     * 删除指定审批模板
     * @param request
     * @param template_id
     * @return
     */
    @RequestMapping("delete/{template_id}")
    @ResponseBody
    public Object deleteApproval(HttpServletRequest request, @PathVariable String template_id) {
        String ip =  request.getSession().getAttribute("ip")+":7010";
        String token = (String) request.getSession().getAttribute("token");
        String tenement = (String) request.getSession().getAttribute("tenementName");
        String result = service.deleteApproval(tenement,template_id,ip,token);
        return result;
    }

    /**
     * 修改指定审批模板
     * @param request
     * @param template_id
     * @return
     */
    @RequestMapping("delete/{template_id}")
    @ResponseBody
    public Object editApproval(HttpServletRequest request, @PathVariable String template_id,@RequestParam Map map) {
        String ip =  request.getSession().getAttribute("ip")+":7010";
        String token = (String) request.getSession().getAttribute("token");
        String tenement = (String) request.getSession().getAttribute("tenementName");
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), new Gson().toJson(map));
        String result = service.editApproval(requestBody,tenement,template_id,ip,token);
        return result;
    }

    /**
     * 启用和禁用审批模板
     * @param request
     * @param template_id
     * @return
     */
    @RequestMapping("delete/{template_id}/{mark}")
    @ResponseBody
    public Object switchApproval(HttpServletRequest request, @PathVariable String template_id,@PathVariable Integer mark) {
        String ip =  request.getSession().getAttribute("ip")+":7010";
        String token = (String) request.getSession().getAttribute("token");
        String tenement = (String) request.getSession().getAttribute("tenementName");
        //mark == 0启用
            String result = service.switchApproval(tenement,mark,template_id,ip,token);
            return result;
    }
}
