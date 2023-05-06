package com.cyobject.black_company_top.domain.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.cyobject.black_company_top.common.config.UpdateGroup;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@TableName(value = "ct_black_information")
@Schema(defaultValue = "ct_black_information", description = "黑榜企业信息表")
public class CtBlackInformationVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(defaultValue = "主键")
    @Size(max = 32, message = "id长度不能超过32", groups = {UpdateGroup.class})
    private String id;

    @Schema(defaultValue = "企业名称")
    @Size(max = 64, message = "企业名称长度不能超过64")
    private String name;

    @Schema(defaultValue = "公司性质")
    @Size(max = 32, message = "公司性质长度不能超过32")
    private String type;

    @Schema(defaultValue = "职场人数(0-10人0，10-20人1，20-50人2，50-100人3，100-200人4，200人以上5)")
    @Max(value = 5, message = "职场人数范围在5以内")
    private Integer employeesNum;

    @Schema(defaultValue = "部门人数(0-10人0，10-20人1，20-50人2，50-100人3，100-200人4，200人以上5)")
    @Max(value = 5, message = "部门人数范围在5以内")
    private Integer departmentNum;

    @Schema(defaultValue = "所属行业")
    @Size(max = 256, message = "所属行业长度不能超过256")
    private String industry;

    @Schema(defaultValue = "业务方向")
    @Size(max = 256, message = "业务方向长度不能超过256")
    private String businessDirection;

    @Schema(defaultValue = "实际工作所在省")
    @Size(max = 16, message = "实际工作所在省长度不能超过256")
    private String province;

    @Schema(defaultValue = "实际工作所在市")
    @Size(max = 16, message = "实际工作所在市长度不能超过256")
    private String city;

    @Schema(defaultValue = "实际工作所在区")
    @Size(max = 16, message = "实际工作所在区长度不能超过256")
    private String district;

    @Schema(defaultValue = "实际工作详细地址")
    @Size(max = 256, message = "实际工作详细地址长度不能超过256")
    private String workAddress;

    @Schema(defaultValue = "休息方式(0双休,1大小周,2单休,3轮班,4倒班,5其他)")
    @Max(value = 5, message = "休息方式范围在5以内")
    private String breakMode;

    @Schema(defaultValue = "上午工作开始时间")
    @NotNull(message = "上午工作开始时间不能为空")
    private LocalDateTime workAmStartTime;

    @Schema(defaultValue = "上午工作结束时间")
    @NotNull(message = "上午工作结束时间不能为空")
    private LocalDateTime workAmEndTime;

    @Schema(defaultValue = "下午工作开始时间")
    @NotNull(message = "下午工作开始时间不能为空")
    private LocalDateTime workPmStartTime;

    @Schema(defaultValue = "下午工作开始时间")
    @NotNull(message = "下午工作开始时间不能为空")
    private LocalDateTime workPmEndTime;

    @Schema(defaultValue = "中午休息分钟数")
    @Size(max = 2, message = "中午休息分钟数长度不能超过2")
    private String breakTimeDay;

    @Schema(defaultValue = "社保缴纳时间(0入职当月的上半月,1入职当月的下半月,2入职的次月,3转正后,4半年后,5一年后,6不缴纳)")
    @Max(value = 6, message = "社保缴纳时间范围在6以内")
    private Integer socialSecurityTime;

    @Schema(defaultValue = "社保基数")
    @Size(max = 5, message = "社保基数长度不能超过5")
    private String socialSecurityBaseFund;

    @Schema(defaultValue = "社保系数(0:8%,1:10%,2:12%)")
    @Max(value = 2, message = "社保系数范围在2以内")
    private String socialSecurityProportion;

    @Schema(defaultValue = "公积金缴纳时间(0入职当月的上半月,1入职当月的下半月,2入职的次月,3转正后,4半年后,5一年后,6不缴纳)")
    @Max(value = 6, message = "公积金缴纳时间范围在6以内")
    private Integer publicAccumulationTime;

    @Schema(defaultValue = "公积金基数")
    @Size(max = 5, message = "公积金基数长度不能超过5")
    private String publicAccumulationFund;

    @Schema(defaultValue = "公积金系数(0:8%,1:10%,2:12%)")
    @Max(value = 2, message = "公积金系数范围在3以内")
    private String publicAccumulationFundProportion;

    @Schema(defaultValue = "是否有影响薪资的绩效考核(0否;1是)")
    @Max(value = 1, message = "是否有影响薪资的绩效考核范围在1以内")
    private Integer performanceAppraisalFlag;

    @Schema(defaultValue = "是否有茶会/下午茶(0没有;1随时,2每周,3每两周,4每月,5每季度,6偶尔)")
    @Max(value = 6, message = "是否有茶会/下午茶范围在6以内")
    private Integer teaPartyFlag;

    @Schema(defaultValue = "是否有过节礼/生日礼(0没有;1法定节日,2额外包含新兴节日)")
    @Max(value = 2, message = "是否有过节礼/生日礼范围在2以内")
    private Integer festivalGiftFlag;

    @Schema(defaultValue = "是否有季度奖(0否;1是)")
    @Max(value = 1, message = "是否有季度奖范围在1以内")
    private Integer quarterlyAwardFlag;

    @Schema(defaultValue = "是否有项目奖(0否;1是)")
    @Max(value = 1, message = "是否有项目奖范围在1以内")
    private Integer projectFlag;

    @Schema(defaultValue = "是否有年终奖(0否;1是)")
    @Max(value = 1, message = "是否有年终奖范围在1以内")
    private Integer annualBonusFlag;

    @Schema(defaultValue = "是否有股权激励(0否;1是)")
    @Max(value = 1, message = "是否有股权激励范围在3以内")
    private Integer equityIncentiveFlag;

    @Schema(defaultValue = "是否有分红(0否;1是)")
    @Max(value = 1, message = "是否有分红范围在1以内")
    private Integer dividendsFlag;

    @Schema(defaultValue = "备注说明")
    @Size(max = 5120, message = "备注说明长度不能超过5120")
    private String comment;

}