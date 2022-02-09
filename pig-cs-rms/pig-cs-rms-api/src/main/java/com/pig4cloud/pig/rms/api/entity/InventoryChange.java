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
package com.pig4cloud.pig.rms.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.pig4cloud.pig.common.mybatis.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Tolerate;

/**
 * 库存详情信息表
 *
 * @author helin
 * @date 2021-10-31 01:01:12
 */
@Data
@TableName("inventory_change")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "库存详情信息表")
@Builder
public class InventoryChange extends BaseEntity {

	@Tolerate
	public InventoryChange() {
	}

	/**
	 * 主键
	 */
	@TableId(type = IdType.AUTO)
	@ApiModelProperty(value = "主键")
	private Long id;

	/**
	 * 库存id
	 */
	@ApiModelProperty(value = "库存id")
	private Long inventoryId;

	/**
	 * 具体原料id
	 */
	@ApiModelProperty(value = "具体原料id")
	private Long rawMaterialDetailsId;

	/**
	 * 变动数量
	 */
	@ApiModelProperty(value = "变动数量")
	private Integer changeNum;

	/**
	 * 变动类型 1：出库 2：入库
	 */
	@ApiModelProperty(value = "变动类型 1：出库 2：入库")
	private Integer changeType;

	/**
	 * 项目id
	 */
	@ApiModelProperty(value = "项目id")
	private Long projectId;

	/**
	 * 备注信息
	 */
	@ApiModelProperty(value = "备注信息")
	private String note;

	/**
	 * 出库、入库人id
	 */
	@ApiModelProperty(value = "出库、入库人id")
	private Long userId;

	/**
	 * 数据记录人id
	 */
	@ApiModelProperty(value = "数据记录人id")
	private Long operatorId;

	/**
	 * 版本号，用于支持乐观锁
	 */
	@ApiModelProperty(value = "版本号，用于支持乐观锁")
	private String version;

	/**
	 * 是否有效 0：有效 1：无效
	 */
	@ApiModelProperty(value = "是否有效 0：有效 1：无效")
	private String delFlag;


}
