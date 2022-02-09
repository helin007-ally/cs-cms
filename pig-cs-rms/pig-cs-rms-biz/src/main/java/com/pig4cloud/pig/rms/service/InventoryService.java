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
import com.pig4cloud.pig.rms.api.entity.Inventory;

/**
 * 库存信息表
 *
 * @author helin
 * @date 2021-10-31 01:01:21
 */
public interface InventoryService extends IService<Inventory> {


	//初始化库存信息，记录操作记录
	Inventory addInventoryAndChange(Long rawMaterialDetailsId, int initAmount);
}
