package com.pc.service;

import com.pc.dao.RoleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleDAO roleDAO;

    public List<String> queryAllRoleNameByUsername(String username) {
        return roleDAO.queryAllRoleNameByUsername(username);
    }
}