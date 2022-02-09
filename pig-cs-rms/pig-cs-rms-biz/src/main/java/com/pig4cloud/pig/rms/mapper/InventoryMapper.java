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

package com.pig4cloud.pig.rms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pig4cloud.pig.rms.api.entity.Inventory;
import org.apache.ibatis.annotations.Mapper;

/**
 * 库存信息表
 *
 * @author helin
 * @date 2021-10-31 01:01:21
 */
@Mapper
public interface InventoryMapper extends BaseMapper<Inventory> {

	//判断当前规格的原料是否已存在库存
	int getInventorAmount(long rawMaterialDetailsId);

}
