package com.formal.partmyself.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.formal.partmyself.pojo.VO.PersonBloodInfo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public interface PersonBloodInfoService extends IService<PersonBloodInfo> {
    List<PersonBloodInfo> getPersonBloodInfo(BigDecimal patientId, Timestamp startTime,Timestamp endTime);

}
