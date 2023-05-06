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
@TableName(value = "ct_black_information")
@Schema(defaultValue = "ct_black_information", description = "黑榜企业信息表")
public class CtBlackInformation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(defaultValue = "主键")
    @TableId
    private String id;

    @Schema(defaultValue = "创建人")
    private String createBy;

    @Schema(defaultValue = "创建时间")
    private LocalDateTime createTime;

    @Schema(defaultValue = "更新人")
    private String updateBy;

    @Schema(defaultValue = "更新时间")
    private LocalDateTime updateTime;

    @Schema(defaultValue = "企业名称")
    private String name;

    @Schema(defaultValue = "公司性质")
    private String type;

    @Schema(defaultValue = "职场人数(0-10人0，10-20人1，20-50人2，50-100人3，100-200人4，200人以上5)")
    private Integer employeesNum;

    @Schema(defaultValue = "部门人数(0-10人0，10-20人1，20-50人2，50-100人3，100-200人4，200人以上5)")
    private Integer departmentNum;

    @Schema(defaultValue = "所属行业")
    private String industry;

    @Schema(defaultValue = "业务方向")
    private String businessDirection;

    @Schema(defaultValue = "实际工作所在省")
    private String province;

    @Schema(defaultValue = "实际工作所在市")
    private String city;

    @Schema(defaultValue = "实际工作所在区")
    private String district;

    @Schema(defaultValue = "实际工作详细地址")
    private String workAddress;

    @Schema(defaultValue = "休息方式(0双休,1大小周,2单休,3轮班,4倒班,5其他)")
    private String breakMode;

    @Schema(defaultValue = "上午工作开始时间")
    private LocalDateTime workAmStartTime;

    @Schema(defaultValue = "上午工作结束时间")
    private LocalDateTime workAmEndTime;

    @Schema(defaultValue = "下午工作开始时间")
    private LocalDateTime workPmStartTime;

    @Schema(defaultValue = "下午工作开始时间")
    private LocalDateTime workPmEndTime;

    @Schema(defaultValue = "中午休息分钟数")
    private String breakTimeDay;

    @Schema(defaultValue = "社保缴纳时间(0入职当月的上半月,1入职当月的下半月,2入职的次月,3转正后,4半年后,5一年后,6不缴纳)")
    private Integer socialSecurityTime;

    @Schema(defaultValue = "社保基数")
    private String socialSecurityBaseFund;

    @Schema(defaultValue = "社保系数")
    private String socialSecurityProportion;

    @Schema(defaultValue = "公积金缴纳时间(0入职当月的上半月,1入职当月的下半月,2入职的次月,3转正后,4半年后,5一年后,6不缴纳)")
    private Integer publicAccumulationTime;

    @Schema(defaultValue = "公积金基数")
    private String publicAccumulationFund;

    @Schema(defaultValue = "公积金系数")
    private String publicAccumulationFundProportion;

    @Schema(defaultValue = "是否有影响薪资的绩效考核(0否;1是)")
    private Integer performanceAppraisalFlag;

    @Schema(defaultValue = "是否有茶会/下午茶(0没有;1随时,2每周,3每两周,4每月,5每季度,6偶尔)")
    private Integer teaPartyFlag;

    @Schema(defaultValue = "是否有过节礼/生日礼(0没有;1法定节日,2额外包含新兴节日)")
    private Integer festivalGiftFlag;

    @Schema(defaultValue = "是否有季度奖(0否;1是)")
    private Integer quarterlyAwardFlag;

    @Schema(defaultValue = "是否有项目奖(0否;1是)")
    private Integer projectFlag;

    @Schema(defaultValue = "是否有年终奖(0否;1是)")
    private Integer annualBonusFlag;

    @Schema(defaultValue = "是否有股权激励(0否;1是)")
    private Integer equityIncentiveFlag;

    @Schema(defaultValue = "是否有分红(0否;1是)")
    private Integer dividendsFlag;

    @Schema(defaultValue = "备注说明")
    private String comment;

    @Schema(defaultValue = "是否删除(0未删,1已删)")
    @TableLogic
    private Boolean deleteFlag;

}