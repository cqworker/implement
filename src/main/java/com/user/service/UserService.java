package com.user.service;

import com.user.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by cq
 * date: 12/5 0005
 */

public interface UserService {
    /**
     * 根据名字获得用户信息
     * @param userName
     * @return
     */
    User findByUserName(String userName);

    /**
     * 获得用户列表
     * @return
     */
    List<User> getUsers();

    /**
     * 用户登录验证
     * @param map
     */
    String  login(Map map);

    /**
     * 注册用户
     * @param map
     * @return
     */
    String register(Map map);
}
