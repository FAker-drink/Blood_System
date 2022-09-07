package com.formal.partmyself.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.formal.partmyself.mapper.PersonBloodInfoMapper;
import com.formal.partmyself.pojo.VO.PersonBloodInfo;
import com.formal.partmyself.service.PersonBloodInfoService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import javax.annotation.Resource;
@Service
public class PersonBloodInfoServiceImpl extends ServiceImpl<PersonBloodInfoMapper, PersonBloodInfo> implements PersonBloodInfoService {

    @Resource
    private PersonBloodInfoMapper personBloodInfoMapper;
    @Override
    public List<PersonBloodInfo> getPersonBloodInfo(BigDecimal patientId, Timestamp startTime,Timestamp endTime) {
        System.out.println(personBloodInfoMapper.getPersonBloodInfo(patientId,startTime,endTime));
        return personBloodInfoMapper.getPersonBloodInfo(patientId,startTime,endTime);

    }
}
