package com.bjpowernode.crm.workbench.controller;

import com.bjpowernode.crm.workbench.bean.Activity;
import com.bjpowernode.crm.workbench.bean.ActivityQueryVo;
import com.bjpowernode.crm.workbench.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedHashSet;
import java.util.List;

/**
 * @ProjectName: crm
 * @Package: com.bjpowernode.crm.settings.controller
 * @Description: java类作用描述
 * @Author: Zhen
 * @CreateDate: 2020/11/16 10:36
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@Controller
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @RequestMapping("activityList")
    @ResponseBody
    public List<Activity> activityList (ActivityQueryVo activityQueryVo){
       List<Activity> activityList= activityService.activityList();


        return activityList;
    }
}
