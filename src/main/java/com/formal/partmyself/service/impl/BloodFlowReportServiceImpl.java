package com.formal.partmyself.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.formal.partmyself.mapper.BloodFlowReportMapper;

import com.formal.partmyself.mapper.PersonBloodInfoMapper;
import com.formal.partmyself.pojo.VO.BloodFlowReport;
import com.formal.partmyself.pojo.VO.PersonBloodInfo;
import com.formal.partmyself.service.BloodFlowReportService;
import com.formal.partmyself.service.PersonBloodInfoService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;

import java.sql.Timestamp;
import java.util.List;
@Service
public class BloodFlowReportServiceImpl extends ServiceImpl<BloodFlowReportMapper,BloodFlowReport> implements BloodFlowReportService {
    @Resource
    private BloodFlowReportMapper bloodFlowReportMapper;

    @Override
    public List<BloodFlowReport> getBloodFlowReport(Timestamp startTime, Timestamp endTime) {
        bloodFlowReportMapper.dropTable();
        bloodFlowReportMapper.createTable();
        bloodFlowReportMapper.insertOutTable(startTime, endTime);
        bloodFlowReportMapper.insertInTable(startTime, endTime);
        bloodFlowReportMapper.insertFailTable(startTime, endTime);
        System.out.println(bloodFlowReportMapper.getBloodFlowReports());
        return bloodFlowReportMapper.getBloodFlowReports();
    }
}
