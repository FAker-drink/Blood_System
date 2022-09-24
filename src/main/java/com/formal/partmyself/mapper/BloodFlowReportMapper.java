package com.formal.partmyself.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.formal.partmyself.pojo.VO.BloodFlowReport;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.sql.Timestamp;
import java.util.List;
@Mapper
public interface BloodFlowReportMapper extends BaseMapper<BloodFlowReport> {
    @Update("DROP TABLE IF EXISTS tmp_table;")
    void dropTable();
    @Update({"create table tmp_table( " +
            "`id` int(11) NOT NULL AUTO_INCREMENT," +
            " `abo_blood_type` varchar(50) NOT NULL  COMMENT 'ABO'," +
            "`rh_blood_type` varchar(50) NOT NULL COMMENT 'RH'," +
            "`blood_type` varchar(50) NOT NULL COMMENT '血液类型'," +
            "`total_out_hp` decimal(50) DEFAULT NULL COMMENT '出库量'," +
            "`total_in_hp` decimal(50) DEFAULT NULL COMMENT '入库量'," +
            "`total_fail_hp` decimal(50) NULL COMMENT '失效量'," +
            " PRIMARY KEY (`id`)"+
            ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='tmp_table';"})
    void createTable();

    @Insert("INSERT INTO tmp_table(abo_blood_type,rh_blood_type,blood_type,total_out_hp)" +
            "(SELECT blood.abo_blood_type,blood.rh_blood_type,blood.blood_components, " +
            "                      sum(blood.hp) as totalOutHp" +
            "                      FROM blood_outbound outbound , blood_base_information blood" +
            "                      WHERE outbound.blood_id=blood.blood_id and outbound.outbound_time BETWEEN #{startTime} and #{endTime}" +
            "                      group by  blood.abo_blood_type,blood.rh_blood_type,blood.blood_components);")
    void insertOutTable(Timestamp startTime, Timestamp endTime);
    @Insert("INSERT INTO tmp_table(abo_blood_type,rh_blood_type,blood_type,total_in_hp)" +
            "(SELECT blood.abo_blood_type,blood.rh_blood_type,blood.blood_components, " +
            "                      sum(blood.hp) as totalInHp" +
            "                      FROM blood_inbound inbound , blood_base_information blood" +
            "                      WHERE inbound.blood_id=blood.blood_id and inbound.inbound_time BETWEEN #{startTime} and #{endTime}" +
            "                      group by  blood.abo_blood_type,blood.rh_blood_type,blood.blood_components);" )
    void insertInTable(Timestamp startTime, Timestamp endTime);
            @Insert("INSERT INTO tmp_table(abo_blood_type,rh_blood_type,blood_type,total_fail_hp)"+
            "(SELECT stocks.abo_blood_type, stocks.rh_blood_type,stocks.variety_of_blood," +
            "                      sum(stocks.hp) as totalFailHp" +
            "                      FROM blood_stocks stocks" +
            "                      WHERE blood_failure_time BETWEEN#{startTime} and #{endTime} AND blood_stocks_condition = 1" +
            "                      group by stocks.variety_of_blood,stocks.rh_blood_type,stocks.abo_blood_type);")
    void insertFailTable(Timestamp startTime, Timestamp endTime);
    @Select("select blood_type,abo_blood_type,rh_blood_type,sum(total_out_hp) as total_out_hp,sum(total_in_hp) as total_in_hp,sum(total_fail_hp) as total_fail_hp from tmp_table group by abo_blood_type,rh_blood_type,blood_type;")
    List<BloodFlowReport> getBloodFlowReports();
    @Select("select blood_type,sum(total_out_hp) as total_out_hp,sum(total_in_hp) as total_in_hp,sum(total_fail_hp) as total_fail_hp from tmp_table group by blood_type;")
    List<BloodFlowReport> getBloodFullReports();;

}
