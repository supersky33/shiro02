package com.pc.realm;


import com.pc.service.PermissionService;
import com.pc.service.RoleService;
import com.pc.service.UserService;
import com.pc.vo.TUser;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.web.context.ContextLoader;

import java.util.HashSet;
import java.util.List;

public class MyRealm extends AuthorizingRealm {


    /**
     * 权限、角色查询
     * @param principalCollection
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("====>权限角色验证");
        String username = (String) principalCollection.getPrimaryPrincipal();
        RoleService roleService = ContextLoader.getCurrentWebApplicationContext().getBean("roleServiceImpl", RoleService.class);
        PermissionService permissionService = ContextLoader.getCurrentWebApplicationContext().getBean("permissionServiceImpl", PermissionService.class);
        List<String> roles = roleService.queryAllRoleNameByUsername(username);
        List<String> permissions = permissionService.queryAllPermissionNameByUsername(username);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(new HashSet<String>(roles));
        simpleAuthorizationInfo.setStringPermissions(new HashSet<String>(permissions));
        return simpleAuthorizationInfo;
    }

    /**
     * 身份认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("====>身份验证");
        String username = authenticationToken.getPrincipal().toString();
        UserService userService = ContextLoader.getCurrentWebApplicationContext().getBean("userServiceImpl", UserService.class);
        TUser user = userService.queryUserByUsername(username);
        if (user == null) {
            return null;
        }
        return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), this.getName());
    }
}
