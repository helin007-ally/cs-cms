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
import com.pig4cloud.pig.rms.api.dto.RawMaterialDto;
import com.pig4cloud.pig.rms.api.entity.RawMaterial;
import com.pig4cloud.pig.rms.service.RawMaterialDetailsService;
import com.pig4cloud.pig.rms.service.RawMaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


/**
 * 材料管理
 *
 * @author 何林
 * @date 2021-10-29 23:31:55
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/rawmaterial")
public class RawMaterialController {

	private final RawMaterialService rawMaterialService;
	private final RawMaterialDetailsService rawMaterialDetailsService;

	/**
	 * 分页查询
	 *
	 * @param page        分页对象
	 * @param rawMaterial 库存明细表
	 * @return
	 */
	@GetMapping("/page")
	@PreAuthorize("@pms.hasPermission('rms_rawmaterial_get')")
	public R getRawMaterialPage(Page page, RawMaterialDto rawMaterial) {
		return R.ok(rawMaterialService.page(page, Wrappers.query(rawMaterial)));
	}

	/**
	 * 获取原料列表
	 *
	 * @return
	 */
	@GetMapping(value = "/list")
	public R getRawMaterialList() {
		return R.ok(rawMaterialService.getList());
	}


	/**
	 * 通过id查询材料表
	 *
	 * @param id id
	 * @return R
	 */
	@GetMapping("/{id}")
	@PreAuthorize("@pms.hasPermission('rms_rawmaterial_get')")
	public R getById(@PathVariable("id") Long id) {
		return R.ok(rawMaterialService.getById(id));
	}

	/**
	 * 新增材料表
	 *
	 * @param rawMaterial 库存明细表
	 * @return R
	 */
	@SysLog("新增材料表")
	@PostMapping
	@PreAuthorize("@pms.hasPermission('rms_rawmaterial_add')")
	public R save(@RequestBody RawMaterial rawMaterial) {
		return R.ok(rawMaterialService.save(rawMaterial));
	}

	/**
	 * 修改材料表
	 *
	 * @param rawMaterial 库存明细表
	 * @return R
	 */
	@SysLog("修改材料")
	@PutMapping
	@PreAuthorize("@pms.hasPermission('rms_rawmaterial_edit')")
	public R updateById(@RequestBody RawMaterial rawMaterial) {
		return R.ok(rawMaterialService.updateById(rawMaterial));
	}

	/**
	 * 通过id删除库存明细表
	 *
	 * @param id id
	 * @return R
	 */
	@SysLog("通过id删除材料信息")
	@DeleteMapping("/{id}")
	@PreAuthorize("@pms.hasPermission('rms_rawmaterial_del')")
	public R removeById(@PathVariable Long id) {
		//删除之前判断有没有关联的规格数据
		if (rawMaterialDetailsService.getRawMaterialDetailsAmount(id) != 0) {
			return R.failed("存在关联的规格数据，请先删除");
		}

		return R.ok(rawMaterialService.removeById(id));
	}

}
