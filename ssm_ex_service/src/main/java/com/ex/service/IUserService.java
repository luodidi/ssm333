package com.ex.service;

import com.whut.bean.UserInfo;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface IUserService {
    Boolean doLogin(UserInfo userInfo);
    List<UserInfo> findAll(int page, int size);
    /*void InsertUser(UserInfo userInfo);
    void DeleteUser(int id);
    UserInfo selectByUsername(String username);
    UserDetails loadUserByUsername(String username);
*/
}
