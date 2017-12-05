package com.user.service;

import com.google.gson.Gson;
import com.user.dao.UserDao;
import com.user.entity.User;
import com.util.api.HttpImpl;
import com.util.api.UserApi;
import okhttp3.ResponseBody;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import retrofit2.Call;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cq
 * date: 12/5 0005
 */
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao dao;
//    @Autowired
//    UserApi api;

    /**
     * 库中查询
     *
     * @param userName
     * @return
     */
    @Override
    public User findByUserName(String userName) {
        return dao.findByUserName(userName);
    }

    /**
     * 调用接口获得用户列表
     *
     * @return
     */
    @Override
    public List<User> getUsers() {
        UserApi api = (UserApi) HttpImpl.getHttpImpl("", UserApi.class, "");
        Call<ResponseBody> users = api.getUsers("");
        //
        return null;
    }

    /**
     * 更新用户
     *
     * @param user
     * @return
     */
    public String updateUser(User user) {
//
        return null;
    }

    /**
     * 用户登录
     *
     * @param dataMap
     */
    @Override
    public String login(Map dataMap) {
        String name = (String) dataMap.get("name");
        String password = (String) dataMap.get("password");

        Integer index = name.trim().length();
        String salt = name.trim().charAt(index > 5 ? index - 4 : 0) + "";
        String pass = new Md5Hash(password.trim(), salt).toString();
        //包装token
        UsernamePasswordToken token = new UsernamePasswordToken(name, pass);

        Subject subject = SecurityUtils.getSubject();
        String code = "";
        String message = "";
        Boolean success = false;
        Map<String, Object> map = new HashMap();


        try {
            //调用login跳转到realm->doGetAuthenticationInfo
            subject.login(token);
            String id = (String) subject.getPrincipal();
            User user = findByUserName(name);
            user.setLastLoginTime(new Date());
            //更新最后登录时间
            updateUser(user);

            code = "1";
            message = "登录成功！";
            success = true;
            map.put("code", code);
            map.put("message", message);
            map.put("success", success);
            map.put("data", "/home/index");
            return new Gson().toJson(map);
        } catch (UnknownAccountException uae) {
            code = "-1";
            message = "用户认证失败：账号不存在";
            map.put("code", code);
            map.put("message", message);
            map.put("data", "/user/toLogin");
            return new Gson().toJson(map);
        } catch (IncorrectCredentialsException ice) {
            code = "-2";
            message = "用户认证失败：密码错误";
            map.put("code", code);
            map.put("message", message);
            map.put("data", "/user/toLogin");
            return new Gson().toJson(map);
        } catch (LockedAccountException lae) {
            code = "-3";
            message = "用户认证失败：账户被锁定";
            map.put("code", code);
            map.put("message", message);
            map.put("data", "/user/toLogin");
            return new Gson().toJson(map);
        } catch (AuthenticationException e) {
            code = "-4";
            message = "身份认证异常：" + e.getMessage();
            map.put("code", code);
            map.put("message", message);
            map.put("data", "/user/toLogin");
            e.printStackTrace();
            token.clear();
            return new Gson().toJson(map);
        } catch (Exception e) {
            code = "-5";
            message = "登录异常";
            map.put("code", code);
            map.put("message", message);
            e.printStackTrace();
            token.clear();
            map.put("data", "/user/toLogin");
            return new Gson().toJson(map);
        }
    }
}
