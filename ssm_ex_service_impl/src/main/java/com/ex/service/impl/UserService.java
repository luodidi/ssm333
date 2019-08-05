package com.ex.service.impl;


import com.github.pagehelper.PageHelper;
import com.whut.bean.Role;
import com.whut.bean.UserInfo;
import com.whut.dao.IRoleDao;
import com.whut.dao.IUserDao;
import com.ex.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserService implements IUserService {

    @Autowired
    private IUserDao userDao;
    @Autowired
    private IRoleDao roleDao;

    @Override
    public Boolean doLogin(UserInfo userInfo) {
        UserInfo userInfo1=userDao.doLogin(userInfo);
        if(null!=userInfo1){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public List<UserInfo> findAll(int page,int size){
        PageHelper.startPage(page,size);
        return userDao.findAll();
    }

 /*   @Override
    public void InsertUser(UserInfo userInfo){ userDao.InsertUser(userInfo); }

    @Override
    public void DeleteUser(int id){userDao.DeleteUser(id);}

    @Override
    public UserInfo selectByUsername(String username) {
        return userDao.selectByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserInfo userInfo=userDao.selectByUsername(username);
        User user=null;
        if (null!=userInfo){
            List<Role> roles=roleDao.findRolesByUserId(userInfo.getId());
            user=new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(),getAuthorities(roles));

        }

        return  user;
    }

    private List<SimpleGrantedAuthority> getAuthorities(List<Role> roles){
        List<SimpleGrantedAuthority> list=new ArrayList<SimpleGrantedAuthority>();

        for(Role role:roles){
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));

        }
        return list;

    }

*/

}
