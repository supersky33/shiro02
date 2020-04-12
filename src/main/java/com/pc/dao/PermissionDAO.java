package com.pc.dao;

import com.pc.vo.TPermission;

import java.util.List;

public interface PermissionDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(TPermission record);

    int insertSelective(TPermission record);

    TPermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TPermission record);

    int updateByPrimaryKey(TPermission record);

    List<String> queryAllPermissionNameByUsername(String username);
}