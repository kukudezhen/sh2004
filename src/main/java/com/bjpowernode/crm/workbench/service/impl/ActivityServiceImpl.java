package com.bjpowernode.crm.workbench.service.impl;

import com.bjpowernode.crm.settings.bean.User;
import com.bjpowernode.crm.settings.mapper.UserMapper;
import com.bjpowernode.crm.workbench.bean.Activity;
import com.bjpowernode.crm.workbench.mapper.ActivityMapper;
import com.bjpowernode.crm.workbench.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityMapper activityMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Activity> activityList() {

        List<Activity> activityList = activityMapper.selectAll();

        for (Activity activity : activityList) {
            //取出市场活动表里的owner   因为市场活动表里的owner是user表里的Id
            String owner = activity.getOwner();
            //在用市场活动表里的owner查出user表里的name
            User user = userMapper.selectByPrimaryKey(owner);
            //把user表里的name给市场活动表里的owner替换
            activity.setOwner(user.getName());
        }

        return activityList;
    }
}
