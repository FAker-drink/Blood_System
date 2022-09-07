package com.formal.partmyself.controller;


import com.formal.partmyself.pojo.entity.BloodPrice;
import com.formal.partmyself.pojo.entity.PatientInformation;
import com.formal.partmyself.pojo.entity.PatientTransfusionInformation;
import com.formal.partmyself.service.BloodPriceService;
import com.formal.partmyself.service.PatientTransfusionInformationService;
import com.formal.partmyself.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author FZX
 * @since 2022-07-31
 */
@Controller
@RequestMapping("//patientTransfusionInformation")
public class PatientTransfusionInformationController {
    @Autowired
    private PatientTransfusionInformationService patientTransfusionInformationService;
    /**
     *  获取需要支付的金额
     *@return
     */
    @ResponseBody
    @GetMapping("/getPayPrice")
    public Result getBloodPrice(BigDecimal patientId) {
        List<Map<String, Object>> payTotle= patientTransfusionInformationService.listPayPrice(patientId);
        if (payTotle != null) {
            System.out.println(payTotle);
            return Result.success(payTotle);
        } else {
            return Result.fail();
        }
    }
    /**
     *  获取费用详细信息（包括已支付和未支付）
     *@return
     */
    @ResponseBody
    @GetMapping("/getPayPriceList")
    public Result getBloodAlonePrice(String payState,BigDecimal patientId) {
        List<PatientTransfusionInformation> payList= patientTransfusionInformationService.listPayAlonePrice(payState,patientId);
        if (payList != null) {
            System.out.println(payList);
            return Result.success(payList);
        } else {
            return Result.fail();
        }
    }


    /**
     * 用于查询某条输血信息
     * @return
     */
    @ResponseBody
    @GetMapping("/getBloodRecoredById")
    public Result getBloodRecoredById( BigDecimal serialNumber) {
        List<PatientTransfusionInformation> BloodRecoredById= patientTransfusionInformationService.getBloodRecoredById(serialNumber);
        if (BloodRecoredById != null) {
            System.out.println(BloodRecoredById);
            return Result.success(BloodRecoredById);
        } else {
            return Result.fail();
        }
    }
}
