package com.formal.partmyself;

import com.formal.partmyself.mapper.PatientTransfusionInformationMapper;
import com.formal.partmyself.pojo.entity.PatientTransfusionInformation;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PartmyselfApplicationTests {

	@Resource
	private PatientTransfusionInformationMapper patientTransfusionInformationMapper;

	@Test
	public void testSelect() {
		System.out.println(("----- selectAll method test ------"));
		//参数是一个Wrapper，条件结构器，这里先不用 填null
		//查询所有的用户
		List<PatientTransfusionInformation> userList = patientTransfusionInformationMapper.selectList(null);
		Assert.assertEquals(1, ((List) userList).size());
		userList.forEach(System.out::println);
	}

}
