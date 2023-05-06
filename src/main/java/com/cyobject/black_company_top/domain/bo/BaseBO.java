package com.cyobject.black_company_top.domain.bo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@Schema(defaultValue = "BaseVo对象", description = "基础Vo")
public class BaseBO implements Serializable {

    @Schema(defaultValue = "页数")
    private Integer pageIndex;

    @Schema(defaultValue = "页面数量")
    private Integer pageSize;

    @Schema(defaultValue = "模糊查询")
    private String search;

}