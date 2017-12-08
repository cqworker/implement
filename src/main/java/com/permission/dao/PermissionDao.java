package com.permission.dao;

import com.permission.entity.Permission;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cq
 * date: 12/5 0005
 */
@Repository
public interface PermissionDao {

    List<Permission> selectPermissionsByUserId(String id);
}
