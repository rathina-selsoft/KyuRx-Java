package com.selsoft.kyurx.doctor.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.selsoft.kyurx.doctor")
@MapperScan("com.selsoft.kyurx.doctor.mapper")
public class DoctionApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctionApplication.class, args);
	}

}
