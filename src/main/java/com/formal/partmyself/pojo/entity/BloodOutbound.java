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
 * @since 2022-08-10
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    @ApiModel(value="BloodOutbound对象", description="")
public class BloodOutbound extends Model<BloodOutbound> {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Long id;

      @ApiModelProperty(value = "创建时间")
      private Date gmtCreate;

      @ApiModelProperty(value = "修改时间")
      private Date gmtModified;

      @ApiModelProperty(value = "出库单据号")
      private String outboundNumber;

      @ApiModelProperty(value = "血液信息")
      private String bloodInformation;

      @ApiModelProperty(value = "出库原因")
      private String outboundReason;

      @ApiModelProperty(value = "出库时间")
      private Date outboundTime;

      @ApiModelProperty(value = "出库地址")
      private String outboundLocation;

      @ApiModelProperty(value = "取血人")
      private String bloodTaker;

      @ApiModelProperty(value = "取血人工号")
      private String bloodTakerNumber;

      @ApiModelProperty(value = "操作人")
      private String operator;

      @ApiModelProperty(value = "操作人工号")
      private String operatorNumber;

      @ApiModelProperty(value = "血液信息表中的id")
      private BigDecimal bloodId;


    @Override
    protected Serializable pkVal() {
          return this.id;
      }

}
