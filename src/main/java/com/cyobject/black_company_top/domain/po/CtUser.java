package com.cyobject.black_company_top.domain.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@TableName("ct_user")
@Schema(defaultValue="CtUser对象", description="用户表")
public class CtUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(defaultValue = "主键")
    @TableId
    private String id;

    @Schema(defaultValue = "创建时间")
    private LocalDateTime createTime;

    @Schema(defaultValue = "更新时间")
    private LocalDateTime updateTime;

    @Schema(defaultValue = "用户编号")
    private String userCode;

    @Schema(defaultValue = "用户名称")
    private String userName;

    @Schema(defaultValue = "性别(0男,1女,2未知)")
    private Boolean gender;

    @Schema(defaultValue = "最后一次登录ip")
    private String lastLoginIp;

    @Schema(defaultValue = "最后一次登录时间")
    private LocalDateTime lastLoginTime;

    @Schema(defaultValue = "联系电话")
    private String phone;

    @Schema(defaultValue = "联系邮箱")
    private String email;

    @Schema(defaultValue = "省份/直辖市")
    private String receiverProvince;

    @Schema(defaultValue = "城市")
    private String receiverCity;

    @Schema(defaultValue = "区")
    private String receiverRegion;

    @Schema(defaultValue = "详细地址")
    private String receiverDetailAddress;

    @Schema(defaultValue = "状态(0未激活,1启用,2停用,3锁定)")
    private Boolean status;

    @Schema(defaultValue = "是否删除(0未删,1已删)")
    @TableLogic
    private Boolean deleteFlag;

}