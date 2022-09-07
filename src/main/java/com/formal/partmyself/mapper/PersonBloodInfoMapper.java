package com.formal.partmyself.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.formal.partmyself.pojo.VO.PersonBloodInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface PersonBloodInfoMapper extends BaseMapper<PersonBloodInfo> {
    @Select(" SELECT patient.name,patient.patient_id,blood.blood_components, " +
            "            blood.abo_blood_type,blood.rh_blood_type,sum(blood.hp) as totalHp" +
            "            FROM patient_transfusion_information patient,blood_base_information blood" +
            "            WHERE patient_id=#{PatientId} and generate_time between #{startTime} and #{endTime}" +
            "and patient.serial_number=blood.blood_id" +
            "            group by blood.abo_blood_type,blood.rh_blood_type,blood.blood_components")
    List<PersonBloodInfo> getPersonBloodInfo(BigDecimal PatientId, Timestamp startTime, Timestamp endTime);
}