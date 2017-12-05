package com.shiroTest;

import com.permission.dao.PermissionDao;
import com.permission.entity.Permission;
import com.role.dao.RoleDao;
import com.role.entity.Role;
import com.user.dao.UserDao;
import com.user.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PermissionDao permissionDao;

    @Autowired
    private RoleDao roleDao;

    /*
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        User user = userDao.findByUserName((String) principals.getPrimaryPrincipal());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        List<Role> roles = roleDao.selectRoleByUserId(user.getId());
        //赋予角色
        for (Role userRole : roles) {
            info.addRole(userRole.getRoleCode());
        }
        //赋予资源
        List<Permission> resourcesList = permissionDao.selectPermissionsByUserId(user.getId());

        if (resourcesList == null || resourcesList.size() == 0) {
            return info;
        }

        for (Permission permission : resourcesList) {
            if (permission != null) {
                info.addStringPermission(permission.getPermissionCode());
            }
        }
        return info;
    }

    /*
     * 登录验证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String userName = token.getUsername();

        User user = userDao.findByUserName(userName);
        if (user != null) {
            if (user.getEnable() == User.DENY) {
                throw new DisabledAccountException();
            }
            //Session中设置用户和菜单
               Session session = SecurityUtils.getSubject().getSession();


            return new SimpleAuthenticationInfo(userName, user.getPassword(), ByteSource.Util.bytes(user.getSalt()), getName());
        } else {
            throw new UnknownAccountException();
        }
    }


}
