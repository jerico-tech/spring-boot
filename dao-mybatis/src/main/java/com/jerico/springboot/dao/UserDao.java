package com.jerico.springboot.dao;

import com.jerico.springboot.entity.UserEntity;

/**
 * @className: UserDao
 * @description:
 * @author: jerico
 * @date: 2020-03-12 00:07
 * @version:
 */
public interface UserDao {
  UserEntity getUser(long id);
}
