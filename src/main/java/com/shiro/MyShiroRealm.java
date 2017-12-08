package com.shiro;

import com.permission.dao.PermissionDao;
import com.permission.entity.Permission;
import com.role.dao.RoleDao;
import com.role.entity.Role;
import com.user.dao.UserDao;
import com.user.entity.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 通过Realm来获取应用程序中的用户、角色及权限信息
 */
@Component
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PermissionDao permissionDao;

    @Autowired
    private RoleDao roleDao;

    /**
     * 验证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        String userName = token.getUsername();

        User user = userDao.findByUserName(userName);

        if (user != null) {
            if (user.getEnable() == User.UNABLE) {
                throw new DisabledAccountException();
            }
            //Session中设置用户和菜单
//            Session session = SecurityUtils.getSubject().getSession();

            //验证
            return new SimpleAuthenticationInfo(userName, user.getPassword(), ByteSource.Util.bytes(user.getSalt()), getName());
        } else {
            throw new UnknownAccountException();
        }
    }

    /**
     * 授权
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        User user = userDao.findByUserName((String) principals.getPrimaryPrincipal());

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //也可以在userDao中连表查询
        List<Role> roles = roleDao.selectRoleByUserId(user.getId());
        if (!(roles == null || roles.size() == 0)) {
            //赋予角色
            for (Role userRole : roles) {
                info.addRole(userRole.getRoleCode());

            }
        }

        List<Permission> permissions = permissionDao.selectPermissionsByUserId(user.getId());
        if (!(permissions == null || permissions.size() == 0)) {
            //赋予权限
            for (Permission permission : permissions) {
                if (permission != null) {
                    info.addStringPermission(permission.getPermissionCode());
                }
            }
        }
        return info;
    }
}