package com.formal.partmyself.pojo.VO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
@Data
public class BloodFlowReport {
        @ApiModelProperty(value = "血液成分")
        private String bloodType;

        @ApiModelProperty(value = "ABO血型")
        private String aboBloodType;

        @ApiModelProperty(value = "RH血型")
        private String rhBloodType;

        @ApiModelProperty(value = "出库血量")
        private BigDecimal totalOutHp;

        @ApiModelProperty(value = "入库血量")
        private BigDecimal totalInHp;

        @ApiModelProperty(value = "失效血量")
        private BigDecimal totalFailHp;

        @ApiModelProperty(value = "静增量")
        private BigDecimal cleanIncrease;
}

