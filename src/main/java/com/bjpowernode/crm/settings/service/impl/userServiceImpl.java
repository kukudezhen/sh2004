package com.bjpowernode.crm.settings.service.impl;

import com.bjpowernode.crm.base.constants.CrmExceptionEnum;
import com.bjpowernode.crm.base.exception.CrmException;
import com.bjpowernode.crm.base.util.DateTimeUtil;
import com.bjpowernode.crm.base.util.MD5Util;
import com.bjpowernode.crm.settings.bean.User;
import com.bjpowernode.crm.settings.mapper.UserMapper;
import com.bjpowernode.crm.settings.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User user) {

        //将用户输入进来的密码进行MD5加密
        user.setLoginPwd(MD5Util.getMD5(user.getLoginPwd()));
        //获取ip并且给ip清空不让其参与查询
            String ip=user.getAllowIps();
            user.setAllowIps(null);

        user = userMapper.selectOne(user);
        //判断用户名密码是否正确
        if (user == null) {
            throw new CrmException(CrmExceptionEnum.LOGIN_ACCOUNT_EXCEPTION);
        } else {
            //判断该账户是否在有效期内是否正确
            if (user.getExpireTime().compareTo(DateTimeUtil.getSysTime()) < 0) {
                throw new CrmException(CrmExceptionEnum.LOGIN_EXPIRE_EXCEPTION);
            }
            //判断账号是否可用
            if ("0".equals(user.getLockState())) {
                throw new CrmException(CrmExceptionEnum.LOGIN_LOCK_EXCEPTION);
            }
            if (!user.getAllowIps().contains(ip)) {
                   throw new CrmException(CrmExceptionEnum.LOGIN_IP_EXCEPTION);
            }
        }
        return user;
    }
}
