package com.dong.mapper;

import com.dong.model.Role;

import java.util.List;

public interface RoleMapper {
    List<Role> getRolesByUid(String uid);
}
