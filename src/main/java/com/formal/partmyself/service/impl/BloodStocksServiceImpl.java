package com.formal.partmyself.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.formal.partmyself.pojo.entity.BloodStocks;
import com.formal.partmyself.mapper.BloodStocksMapper;

import com.formal.partmyself.service.BloodStocksService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author FZX
 * @since 2022-08-01
 */
@Service
public class BloodStocksServiceImpl extends ServiceImpl<BloodStocksMapper, BloodStocks> implements BloodStocksService {
        @Resource
        private  BloodStocksMapper bloodStocksMapper;

    @Override
    public List<BloodStocks> listBlood() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String nowDate = formatter.format(date);
//        更新目前时间已经过期的血液状态（出库的不更新）
        LambdaUpdateWrapper<BloodStocks> bloodStocksWrapper = Wrappers.<BloodStocks>lambdaUpdate()
                .eq(BloodStocks::getBloodStocksCondition,"0")
                .le(BloodStocks::getBloodFailureTime,nowDate)
                .set(BloodStocks::getBloodStocksCondition,"1");
        bloodStocksMapper.update(null,bloodStocksWrapper);
        return this.bloodStocksMapper.selectList(new QueryWrapper<>());
    }



    @Override

    public List<BloodStocks> listBloodAboRh(String abo, String rh,String except) {
        QueryWrapper<BloodStocks> wrapper = new QueryWrapper<>();
        wrapper.eq("abo_blood_type",abo)
                .eq("rh_blood_type",rh);
//        仅显示可用状态的血液
        if(except=="1"){
            wrapper.eq("blood_stocks_condition",0);
        }
        List<BloodStocks> list = this.list(wrapper);
        return list;
    }


    @Override
    public List<BloodStocks> listBloodUseful(String bloodCon) {
        QueryWrapper<BloodStocks> wrapper = new QueryWrapper<>();
        wrapper.eq("blood_stocks_condition",bloodCon);
        List<BloodStocks> list = this.list(wrapper);
        System.out.println(list.getClass().toString());
        return list;
    }

    @Override
    public List<Map<String, Object>> getVarityNumber() {
        QueryWrapper<BloodStocks> bloodNumber =new QueryWrapper<>();
        bloodNumber.groupBy("abo_blood_type", "rh_blood_type","variety_of_blood")
                .gt("TO_DAYS(blood_failure_time)","TO_DAYS(NOW())")
                .ne("blood_stocks_condition","2")
                .select("variety_of_blood,abo_blood_type,rh_blood_type,IFNULL(sum(hp),0)  as totalHp");
        List<Map<String, Object>> maps = this.listMaps(bloodNumber);
        System.out.println(maps.getClass().toString());
        return maps;

    }

    @Override
    public List<BloodStocks> listBloodAlone(String blooId) {
        QueryWrapper<BloodStocks> wrapper = new QueryWrapper<>();
        wrapper.eq("blood_id",blooId);
        List<BloodStocks> list = this.list(wrapper);
        return list;
    }



}
