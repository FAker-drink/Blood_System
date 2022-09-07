package com.formal.partmyself;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.formal.partmyself.mapper")
@SpringBootApplication
public class PartmyselfApplication {

	public static void main(String[] args) { SpringApplication.run(PartmyselfApplication.class, args);
	}

}
