package com.pc.dao;

import com.pc.vo.TRole;

import java.util.List;

public interface RoleDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(TRole record);

    int insertSelective(TRole record);

    TRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TRole record);

    int updateByPrimaryKey(TRole record);

    List<String> queryAllRoleNameByUsername(String username);
}