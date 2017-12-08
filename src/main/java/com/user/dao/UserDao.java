package com.user.dao;

import com.user.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by cq
 * date: 12/5 0005
 */
@Repository
public interface UserDao {
    /**
     * 根据name查询用户
     * @param name
     * @return
     */
    User findByUserName(String name);

    /**
     * 注册用户
     * @param user
     * @return
     */
    Integer addUser(User user);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    Integer updateUser(User user);
}
