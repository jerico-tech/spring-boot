package com.jerico.jmall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
@MapperScan("com.jerico.jmall.dao")
public class JmallApplication {

	public static void main(String[] args) {
		SpringApplication.run(JmallApplication.class, args);
	}

}
