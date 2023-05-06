CREATE TABLE `ct_user`
(
    `id`                      varchar(32) NOT NULL COMMENT '主键',
    `create_time`             timestamp   NOT NULL COMMENT '创建时间',
    `update_time`             timestamp   NOT NULL COMMENT '更新时间',
    `user_code`               varchar(32)  DEFAULT NULL COMMENT '用户编号',
    `user_name`               varchar(32)  DEFAULT NULL COMMENT '用户名称',
    `gender`                  tinyint(1) DEFAULT NULL COMMENT '性别(0男,1女,2未知)',
    `last_login_ip`           varchar(32)  DEFAULT NULL COMMENT '最后一次登录ip',
    `last_login_time`         timestamp    DEFAULT NULL COMMENT '最后一次登录时间',
    `phone`                   varchar(16)  DEFAULT NULL COMMENT '联系电话',
    `email`                   varchar(64)  DEFAULT NULL COMMENT '联系邮箱',
    `receiver_province`       varchar(32)  DEFAULT NULL COMMENT '省份/直辖市',
    `receiver_city`           varchar(32)  DEFAULT NULL COMMENT '城市',
    `receiver_region`         varchar(32)  DEFAULT NULL COMMENT '区',
    `receiver_detail_address` varchar(200) DEFAULT NULL COMMENT '详细地址',
    `status`                  tinyint(1) not null default 0 COMMENT '状态(0未激活,1启用,2停用,3锁定)',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表';

CREATE TABLE `ct_role`
(
    `id`          varchar(32) NOT NULL COMMENT '主键',
    `create_time` timestamp   NOT NULL COMMENT '创建时间',
    `update_time` timestamp   NOT NULL COMMENT '更新时间',
    `role_code`   varchar(32) DEFAULT NULL COMMENT '角色编号',
    `role_name`   varchar(32) DEFAULT NULL COMMENT '角色名称',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色表';

CREATE TABLE `ct_user_role_relation`
(
    `id`          varchar(32) NOT NULL COMMENT '主键',
    `create_time` timestamp   NOT NULL COMMENT '创建时间',
    `update_time` timestamp   NOT NULL COMMENT '更新时间',
    `user_id`     varchar(32) NOT NULL COMMENT '用户主键',
    `user_code`   varchar(32) DEFAULT NULL COMMENT '用户编号',
    `user_name`   varchar(32) DEFAULT NULL COMMENT '用户名称',
    `role_code`   varchar(32) DEFAULT NULL COMMENT '角色编号',
    `role_name`   varchar(32) DEFAULT NULL COMMENT '角色名称',
    `role_id`     varchar(32) NOT NULL COMMENT '角色主键',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户与角色关系表';

CREATE TABLE `ct_role_permission_relation`
(
    `id`               varchar(32) NOT NULL COMMENT '主键',
    `create_time`      timestamp   NOT NULL COMMENT '创建时间',
    `update_time`      timestamp   NOT NULL COMMENT '更新时间',
    `role_code`        varchar(32) DEFAULT NULL COMMENT '角色编号',
    `role_name`        varchar(32) DEFAULT NULL COMMENT '角色名称',
    `role_id`          varchar(32) NOT NULL COMMENT '角色主键',
    `permissions_code` varchar(32) DEFAULT NULL COMMENT '权限编号',
    `permissions_name` varchar(32) DEFAULT NULL COMMENT '权限名称',
    `permissions_id`   varchar(32) NOT NULL COMMENT '权限主键',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色与权限关系表';

CREATE TABLE `ct_permissions`
(
    `id`               varchar(32) NOT NULL COMMENT '主键',
    `create_time`      timestamp   NOT NULL COMMENT '创建时间',
    `update_time`      timestamp   NOT NULL COMMENT '更新时间',
    `permissions_code` varchar(32) DEFAULT NULL COMMENT '权限编号',
    `permissions_name` varchar(32) DEFAULT NULL COMMENT '权限名称',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='权限表';

CREATE TABLE `ct_black_information`
(
    `id`                                  varchar(32) NOT NULL COMMENT '主键',
    `create_by`                           varchar(32) NOT NULL COMMENT '创建人',
    `create_time`                         timestamp   NOT NULL COMMENT '创建时间',
    `update_by`                           varchar(64) NOT NULL COMMENT '更新人',
    `update_time`                         timestamp   NOT NULL COMMENT '更新时间',
    `name`                                varchar(64)   DEFAULT NULL COMMENT '企业名称',
    `type`                                varchar(32) NOT NULL COMMENT '公司性质',
    `employees_num`                       char(1)     NOT NULL COMMENT '职场人数(0-10人0，10-20人1，20-50人2，50-100人3，100-200人4，200人以上5)',
    `department_num`                      char(1)     NOT NULL COMMENT '部门人数(0-10人0，10-20人1，20-50人2，50-100人3，100-200人4，200人以上5)',
    `industry`                            varchar(256)  DEFAULT NULL COMMENT '所属行业',
    `business_direction`                  varchar(256)  DEFAULT NULL COMMENT '业务方向',
    `province`                            varchar(16)   DEFAULT NULL COMMENT '实际工作所在省',
    `city`                                varchar(16)   DEFAULT NULL COMMENT '实际工作所在市',
    `district`                            varchar(16)   DEFAULT NULL COMMENT '实际工作所在区',
    `work_address`                        varchar(256)  DEFAULT NULL COMMENT '实际工作详细地址',
    `break_mode`                          varchar(512)  DEFAULT NULL COMMENT '休息方式(0双休,1大小周,2单休,3轮班,4倒班,5其他)',
    `work_am_start_time`                  timestamp NULL DEFAULT NULL COMMENT '上午工作开始时间',
    `work_am_end_time`                    timestamp NULL DEFAULT NULL COMMENT '上午工作结束时间',
    `work_pm_start_time`                  timestamp NULL DEFAULT NULL COMMENT '下午工作开始时间',
    `work_pm_end_time`                    timestamp NULL DEFAULT NULL COMMENT '下午工作开始时间',
    `break_time_day`                      char(2)       DEFAULT NULL COMMENT '中午休息分钟数',
    `social_security_time`                tinyint(1) NOT NULL COMMENT '社保缴纳时间(0入职当月的上半月,1入职当月的下半月,2入职的次月,3转正后,4半年后,5一年后,6不缴纳)',
    `social_security_base_fund`           varchar(5)    DEFAULT NULL COMMENT '社保基数',
    `social_security_proportion`          char(2)       DEFAULT NULL COMMENT '社保系数(0:8%,1:10%,2:12%)',
    `public_accumulation_time`            tinyint(1) NOT NULL COMMENT '公积金缴纳时间(0入职当月的上半月,1入职当月的下半月,2入职的次月,3转正后,4半年后,5一年后,6不缴纳)',
    `public_accumulation_fund`            varchar(5)    DEFAULT NULL COMMENT '公积金基数',
    `public_accumulation_fund_proportion` char(2)       DEFAULT NULL COMMENT '公积金系数(0:8%,1:10%,2:12%)',
    `performance_appraisal_flag`          tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否有影响薪资的绩效考核(0否;1是)',
    `tea_party_flag`                      tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否有茶会/下午茶(0没有;1随时,2每周,3每两周,4每月,5每季度,6偶尔)',
    `festival_gift_flag`                  tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否有过节礼/生日礼(0没有;1法定节日,2额外包含新兴节日)',
    `quarterly_award_flag`                tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否有季度奖(0否;1是)',
    `project_flag`                        tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否有项目奖(0否;1是)',
    `annual_bonus_flag`                   tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否有年终奖(0否;1是)',
    `equity_incentive_flag`               tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否有股权激励(0否;1是)',
    `dividends_flag`                      tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否有分红(0否;1是)',
    `comment`                             varchar(5120) DEFAULT NULL COMMENT '备注说明',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='黑榜企业信息表';

