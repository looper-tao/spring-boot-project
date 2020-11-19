package com.boot.security.dao;

import com.boot.security.entity.RolePermission;
import java.util.List;

public interface RolePermissionMapper {
    int insert(RolePermission record);

    List<RolePermission> selectAll();
}