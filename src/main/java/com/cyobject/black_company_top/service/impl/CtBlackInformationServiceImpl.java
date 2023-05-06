package com.cyobject.black_company_top.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cyobject.black_company_top.common.config.NotRightException;
import com.cyobject.black_company_top.common.enums.ApiStateEnum;
import com.cyobject.black_company_top.common.utils.APIResult;
import com.cyobject.black_company_top.domain.po.CtBlackInformation;
import com.cyobject.black_company_top.domain.vo.CtBlackInformationVO;
import com.cyobject.black_company_top.mapper.CtBlackInformationMapper;
import com.cyobject.black_company_top.service.CtBlackInformationService;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class CtBlackInformationServiceImpl extends ServiceImpl<CtBlackInformationMapper, CtBlackInformation> implements CtBlackInformationService {

    @Resource
    private CtBlackInformationMapper blackInformationMapper;

    @Override
    public APIResult add(CtBlackInformationVO ctBlackInformationVO) {
        Long selectCount = blackInformationMapper.selectCount(new LambdaQueryWrapper<CtBlackInformation>()
                .eq(CtBlackInformation::getName, ctBlackInformationVO.getName()));
        if (selectCount > 0) {
            throw new NotRightException(ApiStateEnum.REPEAT_ERROR.getCode());
        }
        CtBlackInformation ctBlackInformation = new CtBlackInformation();
        BeanUtils.copyProperties(ctBlackInformationVO, ctBlackInformation);
        int insert = blackInformationMapper.insert(ctBlackInformation);
        if (insert > 0) {
            return APIResult.success().total(insert).message(ApiStateEnum.CREATE_SUCCESS.getMessage());
        }
        throw new NotRightException(ApiStateEnum.CREATE_ERROR.getCode());
    }

    @Override
    public APIResult edit(CtBlackInformationVO ctBlackInformationVO) {
        CtBlackInformation ctBlackInformation = blackInformationMapper.selectById(ctBlackInformationVO.getId());
        if (ObjectUtils.isEmpty(ctBlackInformation)) {
            throw new NotRightException(ApiStateEnum.UNDEFINED_UPDATE_ERROR.getCode());
        }
        BeanUtils.copyProperties(ctBlackInformationVO, ctBlackInformation);
        int update = blackInformationMapper.updateById(ctBlackInformation);
        if (update > 0) {
            return APIResult.success().total(update).message(ApiStateEnum.UPDATE_SUCCESS.getMessage());
        }
        throw new NotRightException(ApiStateEnum.UPDATE_ERROR.getCode());
    }

    @Override
    public APIResult deleteById(String id) {
        CtBlackInformation ctBlackInformation = blackInformationMapper.selectById(id);
        if (ObjectUtils.isEmpty(ctBlackInformation)) {
            throw new NotRightException(ApiStateEnum.UNDEFINED_DELETE_ERROR.getCode());
        }
        int delete = blackInformationMapper.deleteById(id);
        if (delete > 0) {
            return APIResult.success().total(delete).message(ApiStateEnum.DELETE_SUCCESS.getMessage());
        }
        throw new NotRightException(ApiStateEnum.DELETE_ERROR.getCode());
    }

}