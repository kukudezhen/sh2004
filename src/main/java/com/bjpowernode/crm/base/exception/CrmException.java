package com.bjpowernode.crm.base.exception;

import com.bjpowernode.crm.base.constants.CrmExceptionEnum;

public class CrmException extends RuntimeException{

    private CrmExceptionEnum crmExceptionEnum;

    public CrmException(CrmExceptionEnum crmExceptionEnum) {
        super(crmExceptionEnum.getMess());
        this.crmExceptionEnum = crmExceptionEnum;
    }
}
