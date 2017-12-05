package com.shiroTest;

import com.util.md5.MD5Util;
import com.google.gson.Gson;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

//@Controller
public class UserController {

    @RequestMapping("home/index")
    public ModelAndView getIndex(HttpServletRequest request) throws Exception {
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }

    @RequestMapping("/exceptionForPageJumps")
    public ModelAndView exceptionForPageJumps(HttpServletRequest request) throws Exception {
        //  throw new BusinessException(LuoErrorCode.NULL_OBJ);

        return null;
    }

    @RequestMapping(value = "/businessException", method = RequestMethod.POST)
    @ResponseBody
    public String businessException(HttpServletRequest request) {
        //    throw new BusinessException(LuoErrorCode.NULL_OBJ);

        return "";
    }

    @RequestMapping(value = "/otherException", method = RequestMethod.POST)
    @ResponseBody
    public String otherException(HttpServletRequest request) throws Exception {
        throw new Exception();
    }

    //跳转到登录页面
    @RequestMapping("user/login")
    public ModelAndView login() throws Exception {
        ModelAndView mav = new ModelAndView("login");
        return mav;
    }

    //跳转到登录成功页面
    @RequestMapping("user/loginsuccess")
    public ModelAndView loginsuccess() throws Exception {
        ModelAndView mav = new ModelAndView("loginsuccess");
        return mav;
    }

    @RequestMapping("/newPage")
    public ModelAndView newPage() throws Exception {
        ModelAndView mav = new ModelAndView("newPage");
        return mav;
    }

    @RequestMapping("/newPageNotAdd")
    public ModelAndView newPageNotAdd() throws Exception {
        ModelAndView mav = new ModelAndView("newPageNotAdd");
        return mav;
    }

    /**
     * 验证用户名和密码
     *
     * @param username,String password
     * @return
     */
    @RequestMapping(value = "user/checkLogin", method = RequestMethod.POST)
    @ResponseBody
    public String checkLogin(String username, String password) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(username, MD5Util.genMd5(password));
            Subject currentUser = SecurityUtils.getSubject();
            if (!currentUser.isAuthenticated()) {
                //使用shiro来验证
                token.setRememberMe(true);
                currentUser.login(token);//验证角色和权限
            }
        } catch (Exception ex) {
            //   throw new BusinessException(LuoErrorCode.LOGIN_VERIFY_FAILURE);
        }
        result.put("success", true);
        return new Gson().toJson(result);
    }

    /**
     * 退出登录
     */
    @RequestMapping(value = "user/logout", method = RequestMethod.POST)
    @ResponseBody
    public String logout() {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return new Gson().toJson(result);
    }
}