package com.pc.controller;

import com.pc.dao.UserDAO;
import com.pc.pojo.User;
import com.pc.service.UserService;
import com.pc.vo.TUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        System.out.println("goto login page");
        return "login";
    }

    @PostMapping("/login")
    public  String loginLogic(User user){
        System.out.println("login logic");
        // 获取subject 调用login
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        token.setRememberMe(true);
        // 登录失败会抛出异常，交由异常解释器处理
        subject.login(token);
        return "index";
    }

    @GetMapping("/query")
    public String query() {
        System.out.println("query all users");
        return "query";
    }

    @GetMapping("/delete")
    public String delete() {
        System.out.println("delete all users");
        return "delete";
    }

    @GetMapping("/index")
    public String index() {
        System.out.println("index all users");
        return "index";
    }

    @GetMapping("/register")
    public String registerPage() {
        System.out.println("goto register page");
        return "register";
    }

    @PostMapping("/register")
    public String register(TUser user) {
        userService.register(user);
        return "redirect:/user/login";
    }

}
