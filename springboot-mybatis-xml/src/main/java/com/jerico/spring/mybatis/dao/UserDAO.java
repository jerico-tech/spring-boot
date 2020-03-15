package com.jerico.spring.mybatis.dao;

import com.github.pagehelper.Page;
import com.jerico.spring.mybatis.entity.UserEntity;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @className: UserDao
 * @description:
 * @author: jerico
 * @date: 2020-03-13 00:29
 * @version:
 */
@Repository
public interface UserDAO {

  /**
   * 根据id查询用户信息
   *
   * @param id 用户id
   * @return 用户信息
   */
  UserEntity getUser(int id);

  /**
   * 查询所有用户
   *
   * @return 所有用户列表
   */
  Page<UserEntity> listUsers();

  /**
   * 新增用户
   *
   * @param userEntity 用户信息
   * @return 成功的条数
   */
  int insertUser(UserEntity userEntity);

  /**
   * 全量更新用户
   *
   * @param userEntity 用户信息
   * @return 成功的条数
   */
  int updateUser(UserEntity userEntity);

  /**
   * 根据用户id删除用户
   *
   * @param id 用户id
   * @return 成功的条数
   */
  int deleteUser(int id);
}
