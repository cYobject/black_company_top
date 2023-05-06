package com.cyobject.black_company_top.common.config;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HttpException extends RuntimeException {

    //自定义错误码
    private Integer errorCode;

    //自定义状态码
    private Integer httpStatusCode;

    //自定义错误信息
    private String errorMessage;

}