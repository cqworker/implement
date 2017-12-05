package com.permission.dao;

import com.permission.entity.Permission;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by cq
 * date: 12/5 0005
 */
@Component
public interface PermissionDao {

    List<Permission> selectPermissionsByUserId(String id);
}
