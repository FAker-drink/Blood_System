package com.formal.partmyself.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.formal.partmyself.pojo.entity.BloodBaseInformation;
import com.formal.partmyself.mapper.BloodBaseInformationMapper;
import com.formal.partmyself.pojo.entity.BloodStocks;
import com.formal.partmyself.service.BloodBaseInformationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author FZX
 * @since 2022-08-08
 */
@Service
public class BloodBaseInformationServiceImpl extends ServiceImpl<BloodBaseInformationMapper, BloodBaseInformation> implements BloodBaseInformationService {

    @Override
    public HashMap<String, Object> getFrom(String BloodId) {
        LambdaQueryWrapper<BloodBaseInformation> bloodSource =new LambdaQueryWrapper<>();
        bloodSource.eq(BloodBaseInformation::getBloodId,BloodId)
                    .select(BloodBaseInformation::getBloodSource);
        HashMap<String, Object> map = (HashMap<String, Object>) this.listMaps(bloodSource).get(0);
        return map;
    }
}
