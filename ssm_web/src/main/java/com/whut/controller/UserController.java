package com.whut.controller;

import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.sun.tracing.dtrace.Attributes;
import com.whut.bean.UserInfo;
import com.whut.service.IUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("login.do")
    public ModelAndView login(UserInfo userInfo){
        ModelAndView mv=new ModelAndView();
        Boolean flag=userService.doLogin(userInfo);
        if(flag){
            mv.setViewName("main");
        }else{
            mv.setViewName("../failer");
        }
        return mv;
    }

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size){
        List<UserInfo> infos=userService.findAll(page,size);
        ModelAndView mv=new ModelAndView();
        PageInfo pageInfo=new PageInfo(infos);
        mv.addObject("ps",pageInfo);
        mv.setViewName("user-list");
        return mv;
    }

    /*
   @RequestMapping("/save.do")
    public String InsertUser(UserInfo userInfo){
        userService.InsertUser(userInfo);
        return "redirect:findAll.do";
    }

    @RequestMapping("/delete.do")
    public String delect(@PathVariable("id") int id){
        userService.DeleteUser(id);
        return "redirect:findAll.do";
    }
    */
}
