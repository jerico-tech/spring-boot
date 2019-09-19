package com.jerico.jmall.dao;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.jerico.jmall.domain.entity.UserEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @className: UserDao
 * @description: 注解版
 * @author: jerico
 * @date: 2019-09-19 00:31
 * @version:
 */
public interface UserDao {

    @Select("select * from user")
    List<UserEntity> listUsers();

    @Insert("INSERT INTO user(name, age, sex) " +
            "VALUES(#{name}, #{age}, #{sex})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
//   @SelectKey(statement = "select last_insert_id()", keyProperty = "id", before = false, resultType = Integer.class)
    void insert(UserEntity user);

}
