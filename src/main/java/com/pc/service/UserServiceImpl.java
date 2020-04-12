package com.pc.service;

import com.pc.dao.UserDAO;
import com.pc.vo.TUser;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDAO;

    public TUser queryUserByUsername(String username) {
        return userDAO.queryUserByUsername(username);
    }

    public int register(TUser user) {
        String salt = UUID.randomUUID().toString();
        String token = new Sha256Hash(user.getPassword(), salt, 1000).toBase64();
        user.setPassword(token);
        user.setSalt(salt);
        return userDAO.insertSelective(user);
    }
}