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
    @ApiModel(value="BloodInbound对象", description="")
public class BloodInbound extends Model<BloodInbound> {

    private static final long serialVersionUID=1L;

      @ApiModelProperty(value = "编号")
        @TableId(value = "id", type = IdType.AUTO)
      private Long id;

      @ApiModelProperty(value = "创建时间")
      private Date gmtCreate;

      @ApiModelProperty(value = "修改时间")
      private Date gmtModified;

      @ApiModelProperty(value = "入库单据号")
      private String number;

      @ApiModelProperty(value = "入库批次号")
      private Long batchNumber;

      @ApiModelProperty(value = "血站发血单号")
      private BigDecimal bloodNumber;

      @ApiModelProperty(value = "自编流水号")
      private String serialNumber;

      @ApiModelProperty(value = "血液来源")
      private String bloodSource;

      @ApiModelProperty(value = "入库日期")
      private Date inboundTime;

      @ApiModelProperty(value = "血液信息JSON")
      private String bloodMessage;

      @ApiModelProperty(value = "操作者")
      private String operator;

      @ApiModelProperty(value = "血液金额")
      private BigDecimal bloodMoney;

      @ApiModelProperty(value = "血液信息表中的id")
      private BigDecimal bloodId;


    @Override
    protected Serializable pkVal() {
          return this.id;
      }

}
