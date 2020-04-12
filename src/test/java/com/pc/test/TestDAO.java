package com.pc.test;

import com.pc.dao.PermissionDAO;
import com.pc.dao.RoleDAO;
import com.pc.dao.UserDAO;
import com.pc.vo.TUser;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestDAO {

    @Test
    public void testDao() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDAO tUserDao = context.getBean("userDAO", UserDAO.class);
        TUser user = tUserDao.queryUserByUsername("pc");
        System.out.println(user);
    }

    @Test
    public void testRole() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        RoleDAO roleDao = context.getBean("roleDAO", RoleDAO.class);
        List<String> rt = roleDao.queryAllRoleNameByUsername("pc");
        System.out.println(rt);
    }

    @Test
    public void testPermission() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        PermissionDAO permissionDao = context.getBean("permissionDAO", PermissionDAO.class);
        List<String> rt = permissionDao.queryAllPermissionNameByUsername("pc");
        System.out.println(rt);
    }
}
