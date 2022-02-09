/*
 *    Copyright (c) 2018-2025, lengleng All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * Neither the name of the pig4cloud.com developer nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * Author: lengleng (wangiegie@gmail.com)
 */

package com.pig4cloud.pig.rms.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pig4cloud.pig.common.core.util.R;
import com.pig4cloud.pig.common.log.annotation.SysLog;
import com.pig4cloud.pig.rms.api.entity.InventoryChange;
import com.pig4cloud.pig.rms.service.InventoryChangeService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 库存变动信息表
 *
 * @author helin
 * @date 2021-10-31 01:01:12
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/inventorychange" )
@Api(value = "inventorychange", tags = "库存详情信息表管理")
public class InventoryChangeController {

    private final  InventoryChangeService inventoryChangeService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param inventoryChange 库存详情信息表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('rms_inventorychange_get')" )
    public R getInventoryChangePage(Page page, InventoryChange inventoryChange) {
        return R.ok(inventoryChangeService.page(page, Wrappers.query(inventoryChange)));
    }


    /**
     * 通过id查询库存详情信息表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('rms_inventorychange_get')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(inventoryChangeService.getById(id));
    }

    /**
     * 新增库存详情信息表
     * @param inventoryChange 库存详情信息表
     * @return R
     */
    @ApiOperation(value = "新增库存详情信息表", notes = "新增库存详情信息表")
    @SysLog("新增库存详情信息表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('rms_inventorychange_add')" )
    public R save(@RequestBody InventoryChange inventoryChange) {
        return R.ok(inventoryChangeService.save(inventoryChange));
    }

    /**
     * 修改库存详情信息表
     * @param inventoryChange 库存详情信息表
     * @return R
     */
    @ApiOperation(value = "修改库存详情信息表", notes = "修改库存详情信息表")
    @SysLog("修改库存详情信息表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('rms_inventorychange_edit')" )
    public R updateById(@RequestBody InventoryChange inventoryChange) {
        return R.ok(inventoryChangeService.updateById(inventoryChange));
    }

    /**
     * 通过id删除库存详情信息表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除库存详情信息表", notes = "通过id删除库存详情信息表")
    @SysLog("通过id删除库存详情信息表" )
    @DeleteMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('rms_inventorychange_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(inventoryChangeService.removeById(id));
    }

}
