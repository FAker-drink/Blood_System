package com.formal.partmyself.pojo.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 
 * </p>
 *
 * @author FZX
 * @since 2022-08-01
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    @ApiModel(value="BloodStocks对象", description="")
public class BloodStocks extends Model<BloodStocks> {

    private static final long serialVersionUID=1L;

      @ApiModelProperty(value = "血液id")
        private BigDecimal bloodId;

      @ApiModelProperty(value = "主动创建时间")
      @TableField(select = false)
      private Date gmtCreate;

      @ApiModelProperty(value = "被动修改时间")
      @TableField(select = false)
      private Date gmtModified;

      @ApiModelProperty(value = "血液品种")
      private String varietyOfBlood;

      @ApiModelProperty(value = "每袋血液按照血液制品剂量单位标准的血液量")
      private BigDecimal hp;

      @ApiModelProperty(value = "rh血型")
      private String rhBloodType;

      @ApiModelProperty(value = "ABO血型码")
      private String aboBloodType;

      @DateTimeFormat(pattern ="yyyy-MM-dd HH:mm:ss")
      @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
      @ApiModelProperty(value = "血液失效的公元纪年日期时间")
      private Date bloodFailureTime;

      @ApiModelProperty(value = "血液所在库存具体位置描述")
      private String bloodPosition;

      @DateTimeFormat(pattern ="yyyy-MM-dd HH:mm:ss")
      @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
      @ApiModelProperty(value = "血液入库的公元纪年日期时间")
      private Date bloodStorgeTime;

      @ApiModelProperty(value = "血液库存状态代码(0在库中，1已出库，2已失效）")
      private String bloodStocksCondition;


    @Override
    protected Serializable pkVal() {
          return this.bloodId;
      }

}
