package com.shiro;

import com.util.md5.MD5Util;
import com.google.gson.Gson;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


public class UserController {

    /**
     * 验证用户名和密码
     *
     * @param username,String password
     * @return
     */
    @RequestMapping(value = "user/checkLogin", method = RequestMethod.POST)
    @ResponseBody
    public String checkLogin(String username, String password) {
        HashMap dataMap = new HashMap<String, Object>();
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(username, MD5Util.genMd5(password));
            Subject currentUser = SecurityUtils.getSubject();
            if (!currentUser.isAuthenticated()) {
                //使用Shiro来验证
                token.setRememberMe(true);
                //验证角色和权限
                currentUser.login(token);
            }
        } catch (Exception ex) {
            //   throw new BusinessException(LuoErrorCode.LOGIN_VERIFY_FAILURE);
        }
        dataMap.put("success", true);
        return new Gson().toJson(dataMap);
    }

    /**
     * 退出登录
     */
    @RequestMapping(value = "user/logout", method = RequestMethod.POST)
    @ResponseBody
    public String logout() {
        Map dataMap = new HashMap<String, Object>();
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.logout();
        } catch (Exception e) {
            dataMap.put("success", false);
            return new Gson().toJson(dataMap);
        }
        dataMap.put("success", true);
        return new Gson().toJson(dataMap);
    }
}