package com.formal.partmyself.pojo.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author FZX
 * @since 2022-08-08
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    @ApiModel(value="BloodBaseInformation对象", description="")
public class BloodBaseInformation extends Model<BloodBaseInformation> {

    private static final long serialVersionUID=1L;

      @ApiModelProperty(value = "编号")
        @TableId(value = "serial_number", type = IdType.AUTO)
      private Long serialNumber;

      @ApiModelProperty(value = "创建时间")
      private Date gmtCreate;

      @ApiModelProperty(value = "更新时间")
      private Date gmtModified;

      @ApiModelProperty(value = "血装编号条码")
      private BigDecimal barCodeNumber;

      @ApiModelProperty(value = "扩展码")
      private String extendTheCode;

      @ApiModelProperty(value = "血液成分")
      private String bloodComponents;

      @ApiModelProperty(value = "规格")
      private BigDecimal hp;

      @ApiModelProperty(value = "ABO血型")
      private String aboBloodType;

      @ApiModelProperty(value = "RH血型")
      private String rhBloodType;

      @ApiModelProperty(value = "失效时间")
      private Date theFailureTime;

      @ApiModelProperty(value = "采集时间")
      private Date acquisitionTime;

      @ApiModelProperty(value = "血液来源")
      private String bloodSource;

      @ApiModelProperty(value = "状态")
      private String state;

      @ApiModelProperty(value = "入库金额")
      private BigDecimal amountOfInventory;

      @ApiModelProperty(value = "血液ID")
      private BigDecimal bloodId;

      @ApiModelProperty(value = "血袋位置")
      private String bloodbagsPosition;

      @ApiModelProperty(value = "血液金额")
      private BigDecimal bloodAmount;


    @Override
    protected Serializable pkVal() {
          return this.serialNumber;
      }

}
