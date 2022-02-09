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

package com.pig4cloud.pig.rms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pig4cloud.pig.rms.api.entity.RawMaterialDetails;

import java.util.List;

/**
 * 库存明细表
 *
 * @author 何林
 * @date 2021-10-29 23:31:49
 */
public interface RawMaterialDetailsService extends IService<RawMaterialDetails> {

	//保存并更新总库存
	 boolean saveAndUpdateInventory(RawMaterialDetails rawMaterialDetails);
	// 查询并更新总库存
	void queryPageAndUpdateInventory(RawMaterialDetails rawMaterialDetails);
	//获取规格数量
	int getRawMaterialDetailsAmount(Long rawMaterialId);
	//获取规格名称列表
	List<RawMaterialDetails>  getList();

}
