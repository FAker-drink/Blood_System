package com.formal.partmyself.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.formal.partmyself.pojo.entity.PatientInformation;
import com.formal.partmyself.mapper.PatientInformationMapper;
import com.formal.partmyself.service.PatientInformationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author FZX
 * @since 2022-07-31
 */
@Service
public class PatientInformationServiceImpl extends ServiceImpl<PatientInformationMapper, PatientInformation> implements PatientInformationService {

    @Override
    public List<PatientInformation> getPatientById(Integer idcode) {
        QueryWrapper<PatientInformation> wrapper = new QueryWrapper<>();
        //设置查询条件字段sex=1的，eq等于，lt小于，gt大于，还有很多可以到官网查看
        wrapper.eq("idcode",idcode);
        List<PatientInformation> list = this.list(wrapper);
        return list;
    }
}
