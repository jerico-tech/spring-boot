package com.jerico.spring.mybatis.entity;

import lombok.Data;

/**
 * @className: UserEntity
 * @description:
 * @author: jerico
 * @date: 2020-03-13 00:29
 * @version:
 */
@Data
public class UserEntity extends BaseEntity {
  private Integer userId;
  private String userName;
  private String email;
  private String phone;
  private Integer age;
  private Double money;
}
