package com.bjpowernode.crm.workbench.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
     @RequestMapping("/toMainIndex")
    public String toMainIndex(){


        return "main/index";
    }
}
