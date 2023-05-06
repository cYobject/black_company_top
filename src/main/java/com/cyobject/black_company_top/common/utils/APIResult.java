package com.cyobject.black_company_top.common.utils;

import com.cyobject.black_company_top.common.enums.StateEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
@Schema(description = "统一响应对象")
@Accessors(chain = true, fluent = true)
@NoArgsConstructor
public class APIResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 状态码，成功值200，失败请查阅错误编码表
     */
    @Schema(description = "响应状态", example = "可选值参照枚举类")
    private int state = StateEnum.SUCCESS.getCode();

    @Schema(description = "请求路径", example = "/login")
    private String request;

    @Schema(description = "响应消息", example = "操作成功")
    private String message = "";

    @Schema(description = "异常信息", example = "操作失败，username为空")
    private String cause = "";

    @Schema(description = "返回变量-可返回非主体数据", example = "如返回数据ID")
    private Map<String, Object> variables = new HashMap<String, Object>();

    @Schema(description = "返回数据-主体数据", example = "如返回机构对象")
    private T data;

    @Schema(description = "数据数量")
    private int total;

    @Schema(description = "版本号")
    private String version;

//    public APIResult(int state) {
//        super();
//        this.state = state;
//    }
//
//    public APIResult(int state, String message) {
//        this.state = state;
//        this.message = message;
//    }
//
//    public APIResult(int state, String message, String cause) {
//        this.state = state;
//        this.message = message;
//        this.cause = cause;
//    }

    /**
     * 获取变量key的值
     *
     * @param key 变量key
     * @return
     */
    public Object getVariable(String key) {
        if (null == variables) {
            return null;
        }
        return variables.get(key);
    }

    //成功
    public static APIResult success() {
        APIResult r = new APIResult();
        r.state(StateEnum.SUCCESS.getCode());
        r.message(StateEnum.SUCCESS.getText());
        return r;
    }

    //失败
    public static APIResult error() {
        APIResult r = new APIResult();
        r.state(StateEnum.ERROR.getCode());
        r.message(StateEnum.ERROR.getText());
        return r;
    }

    //404(权限不足)
    public static APIResult notFound() {
        APIResult r = new APIResult();
        r.state(StateEnum.NO_PERMISSION.getCode());
        r.message(StateEnum.NO_PERMISSION.getText());
        return r;
    }

    //参数异常
    public static APIResult parameter() {
        APIResult r = new APIResult();
        r.state(StateEnum.PARAMETER_ERROR.getCode());
        r.message(StateEnum.PARAMETER_ERROR.getText());
        return r;
    }

}