package com.whut.dao;

import com.whut.bean.UserInfo;

import java.util.List;

public interface IUserDao {
    UserInfo doLogin(UserInfo userInfo);
    List<UserInfo> findAll();
    /*void InsertUser(UserInfo userInfo);
    void DeleteUser(int id);
    UserInfo selectByUsername(String username);
    */
}

