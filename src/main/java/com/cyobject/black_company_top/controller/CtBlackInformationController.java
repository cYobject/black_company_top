package com.cyobject.black_company_top.controller;


import com.cyobject.black_company_top.common.utils.APIResult;
import com.cyobject.black_company_top.domain.vo.CtBlackInformationVO;
import com.cyobject.black_company_top.service.CtBlackInformationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@Tag(name = "CtBlackInformationController", description = "黑榜企业信息表前端控制器")
@RestController
@RequestMapping("/ct-black-information")
public class CtBlackInformationController {

    @Resource
    private CtBlackInformationService blackInformationService;

    @GetMapping
    @Operation(summary = "query", description = "分页查询")
    public APIResult query(@RequestParam String name,
                           @RequestParam String nam2) {
        return APIResult.success();
    }

    @PostMapping
    @Operation(summary = "add", description = "新增数据")
    public APIResult add(CtBlackInformationVO ctBlackInformationVO) {
        return blackInformationService.add(ctBlackInformationVO);
    }

    @PutMapping
    @Operation(summary = "edit", description = "编辑数据")
    public APIResult edit(CtBlackInformationVO ctBlackInformationVO) {
        return blackInformationService.edit(ctBlackInformationVO);
    }

    @DeleteMapping("deleteById/{id}")
    @Operation(summary = "deleteById", description = "删除数据")
    public APIResult deleteById(@PathVariable String id) {
        return blackInformationService.deleteById(id);
    }

}