package com.formal.partmyself.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.formal.partmyself.mapper.DepartBloodInfoMapper;


import com.formal.partmyself.pojo.VO.DepartBloodInfo;
import com.formal.partmyself.service.DepartBloodInfoService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
@Service
public class DepartBloodInfoServicempl extends ServiceImpl<DepartBloodInfoMapper, DepartBloodInfo> implements DepartBloodInfoService {
    @Resource
    private DepartBloodInfoMapper departBloodInfoMapper;
    @Override
    public List<DepartBloodInfo> getDepartBloodInfo(String department, Timestamp startTime, Timestamp endTime) {
        System.out.println(departBloodInfoMapper.getDepartBloodInfo(department,startTime,endTime));
        return departBloodInfoMapper.getDepartBloodInfo(department,startTime,endTime);
}
}