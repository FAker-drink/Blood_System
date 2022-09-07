package com.formal.partmyself.service;

import com.formal.partmyself.pojo.entity.BloodStocks;
import com.formal.partmyself.pojo.entity.PatientTransfusionInformation;
import com.baomidou.mybatisplus.extension.service.IService;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author FZX
 * @since 2022-08-06
 */
public interface PatientTransfusionInformationService extends IService<PatientTransfusionInformation> {
    List<Map<String, Object>> listPayPrice(BigDecimal patientId);

    List<PatientTransfusionInformation> listPayAlonePrice(String payState,BigDecimal patientId);

    List<PatientTransfusionInformation>getBloodRecoredById(BigDecimal serialNumber);

    HashMap<String, Object> getGO(String bloodId);
}
