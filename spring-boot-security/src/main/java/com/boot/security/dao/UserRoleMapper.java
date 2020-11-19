package com.boot.security.dao;

import com.boot.security.entity.UserRole;
import java.util.List;

public interface UserRoleMapper {
    int insert(UserRole record);

    List<UserRole> selectAll();
}