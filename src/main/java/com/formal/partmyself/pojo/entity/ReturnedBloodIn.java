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
 * 退血入库信息表
 * </p>
 *
 * @author FZX
 * @since 2022-08-01
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    @ApiModel(value="ReturnedBloodIn对象", description="退血入库信息表")
public class ReturnedBloodIn extends Model<ReturnedBloodIn> {

    private static final long serialVersionUID=1L;

      @ApiModelProperty(value = "编号")
        private BigDecimal serialNumber;

      @ApiModelProperty(value = "创建时间")
      private Date gmtCreat;

      @ApiModelProperty(value = "更新时间")
      private Date gmtModified;

      @ApiModelProperty(value = "退血类型")
      private String typeOfReturn;

      @ApiModelProperty(value = "退血信息")
      private String bloodBackInformation;

      @ApiModelProperty(value = "血液信息")
      private String bloodInformation;

      @ApiModelProperty(value = "操作人")
      private String operationer;

      @ApiModelProperty(value = "操作人工号")
      private BigDecimal numberOfoperationer;

      @ApiModelProperty(value = "退血入库时间")
      private Date dateOfBloodEnter;


    @Override
    protected Serializable pkVal() {
          return this.serialNumber;
      }

}
