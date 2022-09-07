package com.formal.partmyself.pojo.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
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
 * @since 2022-07-31
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    @ApiModel(value="PatientInformation对象", description="")
public class PatientInformation extends Model<PatientInformation> {

    private static final long serialVersionUID=1L;

      @ApiModelProperty(value = "病历号")
        private BigDecimal id;

      @ApiModelProperty(value = "主动创建时间")
      private Date gmtCreate;

      @ApiModelProperty(value = "被动更新时间")
      private Date gmtModified;

      @ApiModelProperty(value = "身份证号")
      private BigDecimal idcode;

      @ApiModelProperty(value = "姓名")
      private String name;

      @ApiModelProperty(value = "性别 1男 2女")
      private String gender;

    private BigDecimal age;

      @ApiModelProperty(value = "民族")
      private String national;

      @ApiModelProperty(value = "科别")
      private String department;

      @ApiModelProperty(value = "床号")
      private BigDecimal bednum;

      @ApiModelProperty(value = "既往病史（没有填无）")
      private String pastmedicalhistory;

      @ApiModelProperty(value = "既往输血史（没有填无）")
      private String bloodtansfusionhistor;

      @ApiModelProperty(value = "怀孕（次）(性别为男不填写）")
      private BigDecimal pregnancy;

      @ApiModelProperty(value = "生育次数(性别为男不填写）")
      private BigDecimal production;

      @ApiModelProperty(value = "属地")
      private String territorial;

      @ApiModelProperty(value = "单位")
      private String unit;


    @Override
    protected Serializable pkVal() {
          return this.id;
      }

}
