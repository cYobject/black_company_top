package com.cyobject.black_company_top.common.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;


@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Getter
public enum StateEnum {

    SUCCESS(200, "请求成功"),
    PARAMETER_ERROR(400, "参数异常"),
    NO_PERMISSION(404, "权限异常"),
    ERROR(500, "请求失败");


    private int code;
    private String text;

    StateEnum(int code, String text) {
        this.code = code;
        this.text = text;
    }

}