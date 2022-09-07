package com.formal.partmyself.controller;


import com.formal.partmyself.pojo.entity.BloodStocks;
import com.formal.partmyself.pojo.entity.PatientInformation;
import com.formal.partmyself.service.BloodStocksService;
import com.formal.partmyself.service.PatientInformationService;
import com.formal.partmyself.util.Result;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author FZX
 * @since 2022-08-01
 */
@Controller
@RequestMapping("/bloodStocks")
public class BloodStocksController {
    @Autowired
    private BloodStocksService bloodStocksService;

    /**
     *  获取所有的血液库存信息
     *  同时更新血液状态
     *@return
     */
    @ResponseBody
    @GetMapping("/getBloodInfoAll")
    public Result getBloodInfoAll() {
        List<BloodStocks> bloodList= bloodStocksService.listBlood();
        if (bloodList != null) {
            System.out.println(bloodList);
            return Result.success(bloodList);
        } else {
            return Result.fail();
        }
}
    /**
     * 显示根据血型筛选的血液库存；可以选择是否显示过期/出库血液
     * @return
     */
    @ResponseBody
    @GetMapping("/getBloodAboRh")
    public Result getBloodAboRh(@RequestParam(value = "abo") String abo,
                                @RequestParam(value = "rh") String rh,
                                @RequestParam(value = "except") String except) {
        List<BloodStocks> bloodList= bloodStocksService.listBloodAboRh(abo,rh,except);
        if (bloodList != null) {
            System.out.println(bloodList);
            return Result.success(bloodList);
        } else {
            return Result.fail();
        }
    }
    /**
     * 显示根据状态筛选的血液库存；已出库/库存中/已过期
     * @return
     */
    @ResponseBody
    @GetMapping("/getBloodUseful")
    public Result getBloodUseful(@RequestParam(value = "bloodCon") String bloodCon) {
        List<BloodStocks> bloodList= bloodStocksService.listBloodUseful(bloodCon);
        if (bloodList != null) {
            System.out.println(bloodList);
            return Result.success(bloodList);
        } else {
            return Result.fail();
        }
    }
    /**
     * 用于制作库存分析表
     * @return
     */
    @ResponseBody
    @GetMapping("/getVarityNumber")
    public Result getVarityNumber() {
        List<Map<String, Object>> bloodleft=bloodStocksService.getVarityNumber();
        if (bloodleft != null) {
            System.out.println(bloodleft);
            return Result.success(bloodleft);
        } else {
            return Result.fail();
        }
    }
    /**
     * 根据指定血液id显示血液状况
     * @return
     */
    @ResponseBody
    @GetMapping("/getBloodInfoAlone")
    public Result getBloodInfoAlone(@RequestParam(value = "bloodId") String bloodId) {
        List<BloodStocks> bloodListAlone= bloodStocksService.listBloodAlone(bloodId);
        if (bloodListAlone != null) {
            System.out.println(bloodListAlone);
            return Result.success(bloodListAlone);
        } else {
            return Result.fail();
        }
    }
}
