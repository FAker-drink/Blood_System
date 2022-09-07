package com.formal.partmyself.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.formal.partmyself.pojo.VO.DepartBloodInfo;
import org.apache.ibatis.annotations.Select;
import java.sql.Timestamp;
import java.util.List;


public interface DepartBloodInfoMapper extends BaseMapper<DepartBloodInfo> {
    @Select(" SELECT patient.department,patient.name,patient.patient_id,blood.blood_components, " +
            "            blood.abo_blood_type,blood.rh_blood_type,sum(blood.hp) as totalHp" +
            "            FROM patient_transfusion_information patient,blood_base_information blood" +
            "            WHERE department=#{department} and generate_time between #{startTime} and #{endTime}" +
            "and patient.serial_number=blood.blood_id" +
            "            group by blood.abo_blood_type,blood.rh_blood_type,blood.blood_components")
    List<DepartBloodInfo> getDepartBloodInfo(String department, Timestamp startTime, Timestamp endTime);

}
