package com.pig4cloud.pig.rms.api.dto;


import com.pig4cloud.pig.rms.api.entity.RawMaterial;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
public class RawMaterialDto extends RawMaterial {


	//查询开始时间
	private LocalDateTime beginTime;
	//查询结束时间
	private LocalDateTime EndTime;

}
