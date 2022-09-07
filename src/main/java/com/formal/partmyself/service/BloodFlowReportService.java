package com.formal.partmyself.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.formal.partmyself.pojo.VO.BloodFlowReport;

import java.math.BigDecimal;
import java.security.PublicKey;
import java.sql.Timestamp;
import java.util.List;

public interface BloodFlowReportService extends IService<BloodFlowReport> {
    List<BloodFlowReport> getBloodFlowReport(Timestamp startTime, Timestamp endTime);

}
