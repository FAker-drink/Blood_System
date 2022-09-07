package com.formal.partmyself.controller;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.formal.partmyself.util.Result;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.formal.partmyself.mapper.PatientInformationMapper;
import com.formal.partmyself.mapper.PatientTransfusionInformationMapper;
import com.formal.partmyself.pojo.entity.PatientInformation;
import com.formal.partmyself.service.PatientInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author FZX
 * @since 2022-07-31
 */
@Controller
@RequestMapping("/patientInformation")

public class PatientInformationController {
    @Autowired
    private PatientInformationService  patientInformationService;
    /**
     * 用于查询个人信息
     * @return
     */
    @ResponseBody
    @GetMapping("/getPatientById")
    public Result getPatientById(@RequestParam Integer idcode) {
        List<PatientInformation> patient= patientInformationService.getPatientById(idcode);
        if (patient != null) {
            System.out.println(patient);
            return Result.success(patient);
        } else {
            return Result.fail();
        }
    }
}

