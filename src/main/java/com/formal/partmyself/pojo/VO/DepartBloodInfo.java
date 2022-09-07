package com.formal.partmyself.pojo.VO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class DepartBloodInfo {
    @ApiModelProperty(value = "科别")
    private String department;

    @ApiModelProperty(value = "血液成分")
    private String bloodComponents;

    @ApiModelProperty(value = "规格")
    private BigDecimal totalHp;

    @ApiModelProperty(value = "ABO血型")
    private String aboBloodType;

    @ApiModelProperty(value = "RH血型")
    private String rhBloodType;

}
