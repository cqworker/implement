package com.role.dao;

import com.role.entity.Role;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cq
 * date: 12/5 0005
 */
@Repository
public interface RoleDao {
    List<Role> selectRoleByUserId(String id);
}
