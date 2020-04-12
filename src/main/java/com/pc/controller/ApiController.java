package com.pc.controller;

import com.pc.service.PermissionService;
import com.pc.service.RoleService;
import com.pc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permsService;

    @GetMapping(value = "/user", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Object getUser(String username) {
        return userService.queryUserByUsername(username).getUsername();
    }

    @GetMapping(value = "/role", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Object getRoles(String username) {
        return roleService.queryAllRoleNameByUsername(username).toString();
    }

    @GetMapping(value = "/perm", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Object getPerm(String username) {
        return permsService.queryAllPermissionNameByUsername(username).toString();
    }
}
