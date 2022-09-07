package com.formal.partmyself.service;

import com.formal.partmyself.pojo.entity.BloodStocks;
import com.baomidou.mybatisplus.extension.service.IService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author FZX
 * @since 2022-08-01
 */
public interface BloodStocksService extends IService<BloodStocks> {

    List<BloodStocks> listBlood();

    List<BloodStocks> listBloodAboRh(String abo ,String rh,String except);

    List<BloodStocks> listBloodUseful(String bloodCon);

    List<Map<String, Object>> getVarityNumber();

    List<BloodStocks> listBloodAlone(String blooId);



}
