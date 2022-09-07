package com.formal.partmyself.pojo.VO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PersonBloodInfo {
    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "血液成分")
    private String bloodComponents;

    @ApiModelProperty(value = "规格")
    private BigDecimal totalHp;

    @ApiModelProperty(value = "ABO血型")
    private String aboBloodType;

    @ApiModelProperty(value = "RH血型")
    private String rhBloodType;

    @ApiModelProperty(value = "病例号")
    private BigDecimal patientId;
}
