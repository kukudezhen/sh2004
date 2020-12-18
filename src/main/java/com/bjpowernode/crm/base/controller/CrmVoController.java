package com.bjpowernode.crm.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;

/**
 * @ProjectName: crm
 * @Package: com.bjpowernode.crm.settings.controller
 * @Description: 动态的跳转视图的类
 * @Author: Zhen
 * @CreateDate: 2020/11/16 10:36
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@Controller
public class CrmVoController {
    @RequestMapping("/workbechVo/{firstVo}/{secondVo}")
    public String workbechVo(@PathVariable(value = "firstVo") String firstVo,
                             @PathVariable(value = "secondVo") String secondVo) {

        if (secondVo != null) {
            return File.separator + firstVo + File.separator + secondVo;
        }

        return File.separator + firstVo;

    }
}
