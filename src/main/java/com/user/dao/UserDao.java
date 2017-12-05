package com.user.dao;

import com.user.entity.User;
import org.springframework.stereotype.Component;

/**
 * Created by cq
 * date: 12/5 0005
 */
@Component
public interface UserDao {

    User findByUserName(String primaryPrincipal);
}
