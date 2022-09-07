package com.formal.partmyself.pojo.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
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
 * @since 2022-08-06
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    @ApiModel(value="BloodPrice对象", description="")
public class BloodPrice extends Model<BloodPrice> {

    private static final long serialVersionUID=1L;

      private Long id;

      @ApiModelProperty(value = "主动创建时间")
      private Date gmtCreate;

      @ApiModelProperty(value = "被动修改时间")
      private Date gmtModified;

      @ApiModelProperty(value = "血液价格执行文号")
      private String priceExecutionNumber;
      @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
      @ApiModelProperty(value = "血液价格执行日期")
      private Date priceExecutionDate;

    private String bloodType;

    private BigDecimal bloodPrice;


    @Override
    protected Serializable pkVal() {
          return this.id;
      }

}
