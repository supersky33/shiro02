package com.pc.service;

import com.pc.dao.PermissionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService{

    @Autowired
    private PermissionDAO permissionDAO;

    public List<String> queryAllPermissionNameByUsername(String username) {
        return permissionDAO.queryAllPermissionNameByUsername(username);
    }
}