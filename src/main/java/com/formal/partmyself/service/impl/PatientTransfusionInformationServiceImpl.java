package com.formal.partmyself.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.formal.partmyself.mapper.PatientTransfusionInformationMapper;
import com.formal.partmyself.pojo.entity.PatientTransfusionInformation;
import com.formal.partmyself.service.PatientTransfusionInformationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author FZX
 * @since 2022-07-31
 */
@Service
public class PatientTransfusionInformationServiceImpl extends ServiceImpl<PatientTransfusionInformationMapper, PatientTransfusionInformation> implements PatientTransfusionInformationService {
    @Resource
    private PatientTransfusionInformationMapper patientTransfusionInformationMapper;

    @Override
    public List<Map<String, Object>> listPayPrice(BigDecimal patientId) {
        QueryWrapper<PatientTransfusionInformation> listPaywrapper = new QueryWrapper<>();
        //        筛选掉已支付订单
        listPaywrapper.eq("pay_state",0)
                .eq("patient_id",patientId)
                .select("IFNULL(sum(pay_money),0)  as totalMoney");
        List<Map<String, Object>> maps = this.listMaps(listPaywrapper);
        System.out.println(maps.getClass().toString());
        return maps;
    }

    @Override
    public List<PatientTransfusionInformation> listPayAlonePrice(String payState,BigDecimal patientId) {
        QueryWrapper<PatientTransfusionInformation> listPaywrapper = new QueryWrapper<>();
        listPaywrapper.eq("patient_id",patientId);
        //        筛选订单
      if(payState.equals("1")) {
          listPaywrapper.eq("pay_state", "0");
      }
        List<PatientTransfusionInformation> list = this.list(listPaywrapper);
        return list;
    }

    @Override
    public List<PatientTransfusionInformation> getBloodRecoredById(BigDecimal serialNumber) {
            QueryWrapper<PatientTransfusionInformation> wrapper = new QueryWrapper<>();
            wrapper.eq("serial_number",serialNumber);
            List<PatientTransfusionInformation> list = this.list(wrapper);
            return list;
    }

    @Override
    public HashMap<String, Object> getGO(String bloodId) {
        LambdaQueryWrapper<PatientTransfusionInformation> wrapper =new LambdaQueryWrapper<>();
        wrapper.eq(PatientTransfusionInformation::getSerialNumber,bloodId)
                .select(PatientTransfusionInformation::getName,PatientTransfusionInformation::getDepartment,PatientTransfusionInformation::getPatientId);
        HashMap<String,Object> map = (HashMap<String, Object>) this.listMaps(wrapper).get(0);
        System.out.println(map);
        return map;
    }


}

