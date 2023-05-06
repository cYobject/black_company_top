package com.cyobject.black_company_top.common.config;


import com.cyobject.black_company_top.common.enums.ApiStateEnum;

public class NotRightException extends HttpException {

    public NotRightException(Integer errorCode) {
        ApiStateEnum errorEnumConstant = ApiStateEnum.getApiStateEnum(errorCode);
        this.setHttpStatusCode(errorEnumConstant.getState());
        this.setErrorCode(errorEnumConstant.getCode());
        this.setErrorMessage(errorEnumConstant.getMessage());
    }

}