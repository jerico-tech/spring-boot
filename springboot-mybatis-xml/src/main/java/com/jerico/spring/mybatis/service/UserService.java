package com.jerico.spring.mybatis.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.jerico.spring.mybatis.entity.UserEntity;

/**
 * @className: UserService
 * @description:
 * @author: jerico
 * @date: 2020-03-15 21:35
 * @version:
 */
public interface UserService {

  /**
   * 根据id查询用户信息
   * @param id 用户id
   * @return 用户信息
   */
  UserEntity getUser(int id);

  /**
   * 分页查询用户
   * @param page 第几页
   * @param size 每页多少条
   * @return 查询页的用户信息
   */
  PageInfo<UserEntity> listUsers(int page, int size);

  /**
   * 新增用户
   * @param userEntity 用户信息
   * @return 新增的用户信息
   */
  UserEntity insertUser(UserEntity userEntity);

  /**
   * 全量更新用户信息
   * @param userEntity 用户信息
   * @return 更新后的用户信息
   */
  UserEntity updateUser(UserEntity userEntity);

  /**
   * 根据用户id删除用户
   * @param id 用户id
   */
  void deleteUser(int id);
}
