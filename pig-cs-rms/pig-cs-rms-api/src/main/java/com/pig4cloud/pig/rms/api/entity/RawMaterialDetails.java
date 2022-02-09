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
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.math.BigDecimal;

/**
 * 规格管理
 *
 * @author 何林
 * @date 2021-10-29 23:31:49
 */
@Data
@TableName("raw_material_details")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "规格管理")
public class RawMaterialDetails extends BaseEntity {

    /**
     * 主键
     */
	@TableId(type = IdType.AUTO)
    @ApiModelProperty(value="主键")
    private Long id;

    /**
     * 原料ID
     */
    @ApiModelProperty(value="原料ID")
    private Long rawMaterialId;

    /**
     * 原料具体名称
     */
    @ApiModelProperty(value="原料具体名称")
    private String rawMaterialDetailName;

    /**
     * 数量，入库库存
     */
    @ApiModelProperty(value="数量，入库库存")
    private Integer amount;

    /**
     * 单价
     */
    @ApiModelProperty(value="单价")
    private BigDecimal price;

    /**
     * 长度
     */
    @ApiModelProperty(value="长度")
    private Double length;

    /**
     * 宽度
     */
    @ApiModelProperty(value="宽度")
    private Double width;

    /**
     * 高
     */
    @ApiModelProperty(value="高")
    private Double height;

    /**
     * 版本号，用于支持乐观锁
     */
    @ApiModelProperty(value="版本号，用于支持乐观锁")
    private String version;

    /**
     * 是否有效 0：有效 1：无效
     */
    @ApiModelProperty(value="是否有效 0：有效 1：无效")
    private String delFlag;


}
