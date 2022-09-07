package com.formal.partmyself.service;

import cn.hutool.core.lang.hash.Hash;
import com.formal.partmyself.pojo.entity.BloodBaseInformation;
import com.baomidou.mybatisplus.extension.service.IService;

import java.sql.Timestamp;
import java.util.HashMap;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author FZX
 * @since 2022-08-08
 */
public interface BloodBaseInformationService extends IService<BloodBaseInformation> {
        HashMap<String,Object> getFrom(String BloodId);
}
