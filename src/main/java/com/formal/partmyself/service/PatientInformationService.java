package com.formal.partmyself.service;

import com.formal.partmyself.pojo.entity.PatientInformation;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author FZX
 * @since 2022-07-31
 */
public interface PatientInformationService extends IService<PatientInformation> {
    /**
     * 根据病人ID查找病人信息
     * @param idcode
     * @return
     */

    List<PatientInformation> getPatientById(Integer idcode);
}
