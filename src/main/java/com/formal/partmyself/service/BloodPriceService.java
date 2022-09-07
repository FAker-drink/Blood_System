package com.formal.partmyself.service;

import com.formal.partmyself.pojo.entity.BloodPrice;
import com.baomidou.mybatisplus.extension.service.IService;
import com.formal.partmyself.pojo.entity.BloodStocks;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author FZX
 * @since 2022-08-06
 */
public interface BloodPriceService extends IService<BloodPrice> {
    List<BloodPrice> listBloodPrice();
}
