package com.jerico.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @className: DaoApplication
 * @description:
 * @author: jerico
 * @date: 2020-03-11 23:50
 * @version:
 */
@SpringBootApplication
@MapperScan("com.jerico.springboot.dao")
public class DaoApplication
{
  public static void main(String[] args) {
    //
    SpringApplication.run(DaoApplication.class);
  }
}
