package com.swjd.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.swjd.bean.User;
import com.swjd.service.UserService;
import com.swjd.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/toLogin")
    public String toshoye(Model model, User user){
        model.addAttribute("User",user);
        return "login";
    }
    @RequestMapping("/doLogin")
    public String doLogin(Model model, User user, HttpSession session){
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("id",user.getId());
        queryWrapper.eq("name",user.getName());
        queryWrapper.eq("passw", user.getPassw());
        User u=userService.getOne(queryWrapper);
        if (u!=null){
            //账号密码没有问题
            if (u.getFlag()==1){
                //账号密码存到session里面(登录成功把用户名存到session)
                session.setAttribute("activeName",u.getName());
                return "main";
            }else {
                //账号被禁用了
                model.addAttribute("user",user);
                model.addAttribute("errorMsg","该账号被禁用，请联系管理员");
                return "login";
            }
        }else {
            //账号密码错了
            User user1=new User();
            model.addAttribute("user",user);
            model.addAttribute("errorMsg","账号或者密码错误");
            return "login";
        }
    }
    @RequestMapping("/tozjm")
    public String tozjm(){
        return "zjm";
    }
}
