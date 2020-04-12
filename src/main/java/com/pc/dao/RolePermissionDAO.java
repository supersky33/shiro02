package com.pc.dao;

import com.pc.vo.TRolePermission;

public interface RolePermissionDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(TRolePermission record);

    int insertSelective(TRolePermission record);

    TRolePermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TRolePermission record);

    int updateByPrimaryKey(TRolePermission record);
}