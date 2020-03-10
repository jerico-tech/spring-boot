package com.jerico.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @className: Application
 * @description:
 * @author: jerico
 * @date: 2020-03-11 00:31
 * @version:
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.jerico")
public class Application {
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
