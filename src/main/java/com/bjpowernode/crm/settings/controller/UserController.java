package com.bjpowernode.crm.settings.controller;

import com.bjpowernode.crm.base.constants.CrmConstants;
import com.bjpowernode.crm.base.exception.CrmException;
import com.bjpowernode.crm.base.util.MD5Util;
import com.bjpowernode.crm.settings.bean.User;
import com.bjpowernode.crm.settings.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    String login(User user, Model model, HttpServletRequest request) {
             //获取客户端的ip地址
             user.setAllowIps(request.getRemoteAddr());
        try {
            user = userService.login(user);
            //将用户登录信息写进session中
         request.getSession().setAttribute(CrmConstants.LOGIN_USER,user);
        }catch (CrmException e){
            model.addAttribute("mess",e.getMessage());
            //回写用户名
            model.addAttribute("LoginAct",user.getLoginAct());
            return "../../login";
        }

        return "index";
    }

    @RequestMapping("crmVo")
    void crmVo(){
        return;
    }
}
