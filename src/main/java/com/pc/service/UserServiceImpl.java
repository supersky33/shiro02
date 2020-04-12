package com.pc.service;

import com.pc.dao.UserDAO;
import com.pc.vo.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDAO;

    public TUser queryUserByUsername(String username) {
        return userDAO.queryUserByUsername(username);
    }
}