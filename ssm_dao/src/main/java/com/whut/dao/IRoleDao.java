package com.whut.dao;

import com.whut.bean.Role;

import java.util.List;

public interface IRoleDao {
    public List<Role> findRolesByUserId(int id);
}
