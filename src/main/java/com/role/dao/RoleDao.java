package com.role.dao;

import com.role.entity.Role;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by cq
 * date: 12/5 0005
 */
@Component
public interface RoleDao {


    List<Role> selectRoleByUserId(String id);
}
