package com.bjpowernode.crm.base.constants;

public enum  CrmExceptionEnum {
    LOGIN_ACCOUNT_EXCEPTION("001","用户名或密码错误！"),
    LOGIN_EXPIRE_EXCEPTION("001","该账户已经失效！"),
    LOGIN_LOCK_EXCEPTION("001","该账户已被锁定，请联系管理员！"),
    LOGIN_IP_EXCEPTION("001","当前电脑不可访问，请联系管理员！");

    private String code;  //业务状态码
    private String mess;

    CrmExceptionEnum(String code, String mess) {
        this.code = code;
        this.mess = mess;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }
}
