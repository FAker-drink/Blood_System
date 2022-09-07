package com.formal.partmyself.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.formal.partmyself.pojo.entity.BloodPrice;
import com.formal.partmyself.mapper.BloodPriceMapper;
import com.formal.partmyself.service.BloodPriceService;
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
 * @since 2022-08-06
 */
@Service
public class BloodPriceServiceImpl extends ServiceImpl<BloodPriceMapper, BloodPrice> implements BloodPriceService {

    @Resource
    private BloodPriceMapper bloodPriceMapper;

    @Override
    public List<BloodPrice> listBloodPrice() {
        return this.bloodPriceMapper.selectList(new QueryWrapper<>());
    }


}
