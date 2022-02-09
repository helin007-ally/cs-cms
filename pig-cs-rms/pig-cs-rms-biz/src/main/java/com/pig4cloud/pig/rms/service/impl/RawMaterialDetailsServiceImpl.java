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
package com.pig4cloud.pig.rms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pig4cloud.pig.rms.api.entity.RawMaterial;
import com.pig4cloud.pig.rms.api.entity.RawMaterialDetails;
import com.pig4cloud.pig.rms.mapper.RawMaterialDetailsMapper;
import com.pig4cloud.pig.rms.service.InventoryService;
import com.pig4cloud.pig.rms.service.RawMaterialDetailsService;
import com.pig4cloud.pig.rms.service.RawMaterialService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 库存明细表
 *
 * @author 何林
 * @date 2021-10-29 23:31:49
 */
@Slf4j
@Service
@AllArgsConstructor
public class RawMaterialDetailsServiceImpl extends ServiceImpl<RawMaterialDetailsMapper, RawMaterialDetails> implements RawMaterialDetailsService {

	private final RawMaterialService rawMaterialService;
	private final InventoryService inventoryService;
	private final RawMaterialDetailsMapper rawMaterialDetailsMapper;

	/**
	 * 新增原料规格
	 * 更新原料总库存
	 * 初始化库存记录
	 *
	 * @param rawMaterialDetails 原材料规格
	 * @return
	 */
	@Transactional
    @SneakyThrows
	public boolean saveAndUpdateInventory(RawMaterialDetails rawMaterialDetails) {
		if (null == rawMaterialDetails.getRawMaterialId()){
			throw new Exception("未选择对应的材料");
		}
		RawMaterial rawMaterial = rawMaterialService.getById(rawMaterialDetails.getRawMaterialId());
		if (null == rawMaterial){
			throw new Exception("选择的材料不存在");
		}
		//更新材料总库存
		rawMaterial.setRawMaterialAmount(rawMaterial.getRawMaterialAmount() + rawMaterialDetails.getAmount());
		rawMaterialService.updateById(rawMaterial);
		//保存规格信息
		save(rawMaterialDetails);
		//初始化库存信息表、并记录操作记录
		inventoryService.addInventoryAndChange(rawMaterialDetails.getId(), rawMaterialDetails.getAmount());
		return true;
	}


	@Override
	public void queryPageAndUpdateInventory(RawMaterialDetails rawMaterialDetails) {
		if (null != rawMaterialDetails.getRawMaterialId() && rawMaterialDetails.getRawMaterialId() != 0) {
			//获取原材料数据
			RawMaterial rawMaterial = rawMaterialService.getById(rawMaterialDetails.getRawMaterialId());
			//获取规格数据
			Map hash = new HashMap();
			hash.put("raw_material_id", rawMaterialDetails.getRawMaterialId());
			hash.put("del_flag", "0");
			List<RawMaterialDetails> list = this.listByMap(hash);

			if (!list.isEmpty()) {
				rawMaterial.setRawMaterialAmount(list.stream().mapToLong(r -> r.getAmount()).sum());
			}
			rawMaterialService.updateById(rawMaterial);
		}


	}


	@Override
	public int getRawMaterialDetailsAmount(Long rawMaterialId) {
		return rawMaterialDetailsMapper.getRawMaterialDetailsAmount(rawMaterialId);
	}

	@Override
	public List<RawMaterialDetails> getList() {
		return rawMaterialDetailsMapper.getList();
	}
}
