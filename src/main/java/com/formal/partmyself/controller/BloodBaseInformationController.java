package com.formal.partmyself.controller;


import cn.hutool.core.date.DateTime;
import com.formal.partmyself.pojo.entity.BloodStocks;
import com.formal.partmyself.service.*;
import com.formal.partmyself.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author FZX
 * @since 2022-08-08
 */
@Controller
@RequestMapping("/bloodBaseInformation")
public class BloodBaseInformationController {
    @Autowired
    private PersonBloodInfoService personBloodInfoService;

    /**
     *  获取个人用血统计
     *@return
     */
    @GetMapping("/getPersonBloodInfo")
    @ResponseBody
    public Result getPersonBloodInfo(@RequestParam(value = "patientId")BigDecimal patientId,
                                     @RequestParam(value = "startTime")  String startTimePatient,
                                     @RequestParam(value = "endTime") String endTimePatient) {
        Timestamp startTime = Timestamp.valueOf(startTimePatient);
        Timestamp endTime = Timestamp.valueOf(endTimePatient);
        return Result.success(personBloodInfoService.getPersonBloodInfo(patientId,startTime,endTime));
    }
    /**
     *  获取科室用血统计
     *@return
     */
    @Autowired
    private DepartBloodInfoService departBloodInfoService;

    @GetMapping("/getDepartBloodInfo")
    @ResponseBody
    public Result getDepartBloodInfo(@RequestParam(value = "department")String department,
                                     @RequestParam(value = "startTime")  String startTime,
                                     @RequestParam(value = "endTime") String endTime) {

        Timestamp startTime1 = Timestamp.valueOf(startTime);
        Timestamp endTime1 = Timestamp.valueOf(endTime);

        return Result.success(departBloodInfoService.getDepartBloodInfo(department,startTime1,endTime1));
    }
    /**
     *  统计各种血液流通情况
     *@return
     */
    @Autowired
    private BloodFlowReportService bloodFlowReportService;

    @GetMapping("/getBloodFlowReport")
    @ResponseBody
    public Result getBloodFlowReport(
                                     @RequestParam(value = "startTime") Timestamp startTime,
                                     @RequestParam(value = "endTime") Timestamp endTime) {

        return Result.success(bloodFlowReportService.getBloodFlowReport(startTime,endTime));
    }

    /**
     *  追踪某批次血液去向
     *@return
     */
    @Autowired
    private BloodStocksService bloodStocksService;
    @Autowired
    private BloodBaseInformationService bloodBaseInformationService;
    @Autowired
    private PatientTransfusionInformationService patientTransfusionInformationService;
    @GetMapping("/getBloodGo")
    @ResponseBody
    public Result getBloodGo(@RequestParam(value = "bloodId") String bloodId) {
        HashMap<String, Object> getResult=new HashMap<>();
        bloodBaseInformationService.getFrom(bloodId).forEach(getResult::put);
        List<BloodStocks> bloodListAlone= bloodStocksService.listBloodAlone(bloodId);
        System.out.println(bloodListAlone);
        String placeState = bloodListAlone.get(0).getBloodStocksCondition();
        String varietyOfBlood =bloodListAlone.get(0).getVarietyOfBlood();
        BigDecimal hp= bloodListAlone.get(0).getHp();
        String rhBloodType =bloodListAlone.get(0).getRhBloodType();
        String aboBloodType =bloodListAlone.get(0).getAboBloodType();
        getResult.put("varietyOfBlood",varietyOfBlood);
        getResult.put("hp",hp);
        getResult.put("rhBloodType",rhBloodType);
        getResult.put("aboBloodType",aboBloodType);
        if (placeState.equals("0")||placeState.equals("1")) {
            getResult.put("placeState",placeState);
            //为0代表未过期;为1代表已过期
            getResult.put("stay","库内："+bloodListAlone.get(0).getBloodPosition());
            System.out.println(getResult);
            List myList = new ArrayList();
            myList.add(getResult);
            return Result.success(myList);
        } else if(placeState.equals("2")){
            patientTransfusionInformationService.getGO(bloodId).forEach(getResult::put);
            getResult.put("stay","已出库");
            System.out.println(getResult);
            List myList = new ArrayList();
            myList.add(getResult);
            return Result.success(myList);
        }else {
            return Result.fail();
        }
    }
}
