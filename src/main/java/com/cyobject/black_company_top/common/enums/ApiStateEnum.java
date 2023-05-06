package com.cyobject.black_company_top.common.enums;

import lombok.Getter;
import org.springframework.util.ObjectUtils;

@Getter
public enum ApiStateEnum {

    SELECT_SUCCESS(2100, StateEnum.SUCCESS.getCode(), "查询成功"),
    CREATE_SUCCESS(2200, StateEnum.SUCCESS.getCode(), "新增成功"),
    UPDATE_SUCCESS(2300, StateEnum.SUCCESS.getCode(), "更新成功"),
    DELETE_SUCCESS(2400, StateEnum.SUCCESS.getCode(), "删除成功"),

    SELECT_ERROR(5100, StateEnum.ERROR.getCode(), "查询失败"),
    CREATE_ERROR(5200, StateEnum.ERROR.getCode(), "新增失败"),
    UPDATE_ERROR(5300, StateEnum.ERROR.getCode(), "更新失败"),
    DELETE_ERROR(5400, StateEnum.ERROR.getCode(), "删除失败"),

    USED_DELETE_ERROR(5401, StateEnum.ERROR.getCode(), "已被绑定使用,删除失败"),
    HAS_CHILDREN_DELETE_ERROR(5402, StateEnum.ERROR.getCode(), "存在下属层级,删除失败"),
    UNDEFINED_DELETE_ERROR(5403, StateEnum.ERROR.getCode(), "删除数据不存在,删除失败"),
    UNDEFINED_UPDATE_ERROR(5404, StateEnum.ERROR.getCode(), "更新数据不存在,更新失败"),
    REPEAT_ERROR(5500, StateEnum.ERROR.getCode(), "已存在该记录"),

    NULL_POINT_ERROR(5600, StateEnum.ERROR.getCode(), "NPE"),
    SQL_ERROR(5700, 500, "SQL运行异常"),
    OTHER_ERROR(9999, 500, "未知异常"),

    NOT_ALLOW_PARAMETER_ERROR(4001, StateEnum.PARAMETER_ERROR.getCode(), "非法参数"),
    NOT_HAS_SELECT_ERROR(4002, StateEnum.NO_PERMISSION.getCode(), "查询不到匹配的对象"),
    NO_PERMISSION(4003, StateEnum.NO_PERMISSION.getCode(), "没有权限，请联系管理员授权"),
    NOT_FOUND_ERROR(4004, StateEnum.NO_PERMISSION.getCode(), "路径不存在，请检查路径是否正确"),
    REQUIRED_DATA_ERROR(4005, StateEnum.PARAMETER_ERROR.getCode(), "必填数据为空"),
    REQUIRED_PREREQUISITE_ERROR(4006, StateEnum.PARAMETER_ERROR.getCode(), "必要条件为空");

    //错误代码
    private Integer code;

    //错误状态码
    private Integer state;

    //错误消息
    private String message;


    ApiStateEnum(Integer code, Integer state, String message) {
        this.code = code;
        this.state = state;
        this.message = message;
    }

    public static ApiStateEnum getApiStateEnum(Integer code) {
        if (!ObjectUtils.isEmpty(code)) {
            for (ApiStateEnum result : ApiStateEnum.values()) {
                if (result.code.equals(code)) {
                    return result;
                }
            }
        }
        return null;
    }

}