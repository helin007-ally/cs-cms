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
import com.pig4cloud.pig.rms.api.entity.Inventory;
import com.pig4cloud.pig.rms.api.entity.InventoryChange;
import com.pig4cloud.pig.rms.mapper.InventoryMapper;
import com.pig4cloud.pig.rms.service.InventoryChangeService;
import com.pig4cloud.pig.rms.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 库存信息表
 *
 * @author helin
 * @date 2021-10-31 01:01:21
 */
@Service
public class InventoryServiceImpl extends ServiceImpl<InventoryMapper, Inventory> implements InventoryService {

	@Autowired
	private InventoryMapper inventoryMapper;
	@Autowired
	private InventoryChangeService inventoryChangeService;


	/**
	 * 新增原料规格并更新原料总库存
	 *
	 * @param rawMaterialDetailsId 规格id
	 * @param initAmount           初始化 库存数量
	 * @return
	 */
	@Override
	@Transactional
	public Inventory addInventoryAndChange(Long rawMaterialDetailsId, int initAmount) {
		//判断是否已存在库存记录
		//存在不做处理
		int inventoryRecord = inventoryMapper.getInventorAmount(rawMaterialDetailsId);
		if (inventoryRecord != 0) {
			return null;
		}
		//不存在新增一条库存记录,并增加状态为初始化(0)的明细记录
		Inventory inventory = new Inventory();
		inventory.setRawMaterialDetailsId(rawMaterialDetailsId);
		inventory.setInventory(initAmount);
		this.save(inventory);
		InventoryChange inventoryChange = InventoryChange.builder()
				.inventoryId(inventory.getId())
				.rawMaterialDetailsId(rawMaterialDetailsId)
				.changeType(0)
				.changeNum(initAmount)
				.build();
		inventoryChangeService.save(inventoryChange);
		return inventory;
	}
}
