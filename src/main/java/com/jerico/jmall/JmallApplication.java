package com.jerico.jmall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jerico.jmall.dao")
public class JmallApplication {

	public static void main(String[] args) {
		SpringApplication.run(JmallApplication.class, args);
	}

}
