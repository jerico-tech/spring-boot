package com.jerico.springboot.entity;

import lombok.Data;

/**
 * @className: UserEntity
 * @description:
 * @author: jerico
 * @date: 2020-03-12 00:09
 * @version:
 */
@Data
public class UserEntity {
  private Long id;
  private String name;
  private String email;
  private String phone;
  private Integer age;
}
