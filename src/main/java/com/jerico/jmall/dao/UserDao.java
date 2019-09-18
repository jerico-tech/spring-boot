package com.jerico.jmall.dao;

import com.github.pagehelper.Page;
import com.jerico.jmall.domain.entity.UserEntity;
import org.apache.ibatis.annotations.Select;

/**
 * @className: UserDao
 * @description:
 * @author: jerico
 * @date: 2019-09-19 00:31
 * @version:
 */
public interface UserDao {

    @Select("select * from user")
    Page<UserEntity> listUsers();
}
