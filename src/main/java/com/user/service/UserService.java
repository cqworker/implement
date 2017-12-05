package com.user.service;

import com.user.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cq
 * date: 12/5 0005
 */
@Service
public interface UserService {
    /**
     * 根据名字获得用户信息
     * @param userName
     * @return
     */
    User getUserByUserName(String userName);

    /**
     * 获得用户列表
     * @return
     */
    List<User> getUsers();
}
