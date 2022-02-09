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
import com.pig4cloud.pig.rms.api.entity.RawMaterialDetails;
import com.pig4cloud.pig.rms.service.RawMaterialDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


/**
 * 规格表
 *
 * @author 何林
 * @date 2021-10-29 23:31:49
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/rawmaterialdetails")
public class RawMaterialDetailsController {

	private final RawMaterialDetailsService rawMaterialDetailsService;


	@GetMapping("/page")
	@PreAuthorize("@pms.hasPermission('rms_rawmaterialdetails_get')")
	public R getRawMaterialDetailsPage(Page page, RawMaterialDetails rawMaterialDetails) {
		if (null != rawMaterialDetails) {
			rawMaterialDetailsService.queryPageAndUpdateInventory(rawMaterialDetails);
		}
		return R.ok(rawMaterialDetailsService.page(page, Wrappers.query(rawMaterialDetails)));
	}


	@GetMapping("/{id}")
	@PreAuthorize("@pms.hasPermission('rms_rawmaterialdetails_get')")
	public R getById(@PathVariable("id") Long id) {
		return R.ok(rawMaterialDetailsService.getById(id));
	}


	@GetMapping("/list")
	public R getRawMaterialDetailsList() {
		return R.ok(rawMaterialDetailsService.getList());
	}


	@SysLog("新增规格信息")
	@PostMapping
	@PreAuthorize("@pms.hasPermission('rms_rawmaterialdetails_add')")
	public R save(@RequestBody RawMaterialDetails rawMaterialDetails) {
		return R.ok(rawMaterialDetailsService.saveAndUpdateInventory(rawMaterialDetails));
	}


	@SysLog("规格材料")
	@PutMapping
	@PreAuthorize("@pms.hasPermission('rms_rawmaterialdetails_edit')")
	public R updateById(@RequestBody RawMaterialDetails rawMaterialDetails) {
		return R.ok(rawMaterialDetailsService.updateById(rawMaterialDetails));
	}


	@SysLog("通过id删除规格信息")
	@DeleteMapping("/{id}")
	@PreAuthorize("@pms.hasPermission('rms_rawmaterialdetails_del')")
	public R removeById(@PathVariable Long id) {
		return R.ok(rawMaterialDetailsService.removeById(id));
	}

}
