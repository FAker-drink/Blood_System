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
import org.springframework.format.annotation.DateTimeFormat;

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
    @ApiModel(value="PatientTransfusionInformation对象", description="")
public class PatientTransfusionInformation extends Model<PatientTransfusionInformation> {

    private static final long serialVersionUID=1L;

      @ApiModelProperty(value = "病历号")
        private Long id;

      @ApiModelProperty(value = "主动创建")
      private Date gmtCreate;

      @ApiModelProperty(value = "被动修改")
      private Date gmtModified;

      @ApiModelProperty(value = "姓名")
      private String name;

      @DateTimeFormat(pattern ="yyyy-MM-dd HH:mm:ss")
      @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
      @ApiModelProperty(value = "创建订单时间")
      private Date generateTime;

      @ApiModelProperty(value = "血液类型")
      private String bloodType;

      @ApiModelProperty(value = "血液数量(全血每200ml统计为1个单位)")
      private BigDecimal hp;

      @ApiModelProperty(value = "科别")
      private String department;

      @ApiModelProperty(value = "付款")
      private BigDecimal payMoney;

      @ApiModelProperty(value = "状态包括（待取血、已使用、待退血、退血申请驳回）")
      private String payState;

      @ApiModelProperty(value = "血液编号")
      private BigDecimal serialNumber;

      @ApiModelProperty(value = "病例号")
      private BigDecimal patientId;

    @Override
    protected Serializable pkVal() {
          return this.id;
      }

}
