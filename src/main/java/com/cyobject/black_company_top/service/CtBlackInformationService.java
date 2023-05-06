package com.cyobject.black_company_top.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cyobject.black_company_top.common.utils.APIResult;
import com.cyobject.black_company_top.domain.po.CtBlackInformation;
import com.cyobject.black_company_top.domain.vo.CtBlackInformationVO;

public interface CtBlackInformationService extends IService<CtBlackInformation> {

    APIResult add(CtBlackInformationVO ctBlackInformationVO);

    APIResult edit(CtBlackInformationVO ctBlackInformationVO);

    APIResult deleteById(String id);

}