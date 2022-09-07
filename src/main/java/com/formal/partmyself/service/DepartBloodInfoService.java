package com.formal.partmyself.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.formal.partmyself.pojo.VO.DepartBloodInfo;

import java.sql.Timestamp;
import java.util.List;

public interface DepartBloodInfoService extends IService<DepartBloodInfo> {
    List<DepartBloodInfo> getDepartBloodInfo(String department, Timestamp startTime, Timestamp endTime);
}
