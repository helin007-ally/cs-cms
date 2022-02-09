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
import com.pig4cloud.pig.rms.mapper.RawMaterialMapper;
import com.pig4cloud.pig.rms.service.RawMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 库存明细表
 *
 * @author 何林
 * @date 2021-10-29 23:31:55
 */
@Service
public class RawMaterialServiceImpl extends ServiceImpl<RawMaterialMapper, RawMaterial> implements RawMaterialService {


	@Autowired
	private  RawMaterialMapper rawMaterialMapper;

	@Override
	public List<RawMaterial> getList() {
		return	rawMaterialMapper.getList();
	}
}
