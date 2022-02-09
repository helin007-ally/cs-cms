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
import com.pig4cloud.pig.rms.api.entity.Inventory;
import com.pig4cloud.pig.rms.service.InventoryService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 库存信息表
 *
 * @author helin
 * @date 2021-10-31 01:01:21
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/inventory" )
@Api(value = "inventory", tags = "库存信息表管理")
public class InventoryController {

    private final  InventoryService inventoryService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param inventory 库存信息表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('rms_inventory_get')" )
    public R getInventoryPage(Page page, Inventory inventory) {
        return R.ok(inventoryService.page(page, Wrappers.query(inventory)));
    }


    /**
     * 通过id查询库存信息表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('rms_inventory_get')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(inventoryService.getById(id));
    }

    /**
     * 新增库存信息表
     * @param inventory 库存信息表
     * @return R
     */
    @ApiOperation(value = "新增库存信息表", notes = "新增库存信息表")
    @SysLog("新增库存信息表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('rms_inventory_add')" )
    public R save(@RequestBody Inventory inventory) {
        return R.ok(inventoryService.save(inventory));
    }

    /**
     * 修改库存信息表
     * @param inventory 库存信息表
     * @return R
     */
    @ApiOperation(value = "修改库存信息表", notes = "修改库存信息表")
    @SysLog("修改库存信息表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('rms_inventory_edit')" )
    public R updateById(@RequestBody Inventory inventory) {
        return R.ok(inventoryService.updateById(inventory));
    }

    /**
     * 通过id删除库存信息表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除库存信息表", notes = "通过id删除库存信息表")
    @SysLog("通过id删除库存信息表" )
    @DeleteMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('rms_inventory_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(inventoryService.removeById(id));
    }

}
