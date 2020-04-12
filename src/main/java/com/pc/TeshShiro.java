package com.pc;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;

public class TeshShiro {

    public static void main(String[] args) {
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        IniRealm iniRealm = new IniRealm("classpath:shiro.ini");
        securityManager.setRealm(iniRealm);
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken("zhangsan1", "123");
            try {
                subject.login(token);
            } catch (UnknownAccountException u) {
                System.out.println("用户不存在");
            } catch (IncorrectCredentialsException u) {
                System.out.println("密码错误");
            } catch (AuthenticationException u) {
                System.out.println(u.toString());
            }
        }
        System.out.println(subject.getPrincipal() + "=>login successfully");
    }
}
