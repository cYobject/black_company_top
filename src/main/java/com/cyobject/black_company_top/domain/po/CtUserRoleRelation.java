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
@TableName("ct_user_role_relation")
@Schema(defaultValue = "CtUserRoleRelation对象", description = "用户与角色关系表")
public class CtUserRoleRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(defaultValue = "主键")
    @TableId
    private String id;

    @Schema(defaultValue = "创建时间")
    private LocalDateTime createTime;

    @Schema(defaultValue = "更新时间")
    private LocalDateTime updateTime;

    @Schema(defaultValue = "用户主键")
    private String userId;

    @Schema(defaultValue = "用户编号")
    private String userCode;

    @Schema(defaultValue = "用户名称")
    private String userName;

    @Schema(defaultValue = "角色编号")
    private String roleCode;

    @Schema(defaultValue = "角色名称")
    private String roleName;

    @Schema(defaultValue = "角色主键")
    private String roleId;

    @Schema(defaultValue = "是否删除(0未删,1已删)")
    @TableLogic
    private Boolean deleteFlag;

}