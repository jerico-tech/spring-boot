package com.jerico.jmall.dao;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.jerico.jmall.domain.entity.UserEntity;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @className: UserDao
 * @description: 注解版
 * @author: jerico
 * @date: 2019-09-19 00:31
 * @version:
 */
//@Repository可以不加，在这里加上是为了消除@Autowire时产生的错误提示
@Repository
public interface UserDAO {
    @Select("select * from user where id = #{id}")
    UserEntity getUserById(@Param("id") long id);

    @Select("select * from user where ${column} = #{value}")
    UserEntity getUserByColumn(@Param("column") String column, @Param("value") String value);

    @Select("select * from user")
    List<UserEntity> listUsersA();

    /**
     * insert 这里用了一个 @Options 的注解，实现了「主键回填」的功能，也就是说，再创建好一个 user 之后，user 请求体中的 id 属性会自动赋值好；
     * @SelectKey 注解被注释掉了，这个注解也同样可以实现「主键回填」的功能；//   @SelectKey(statement = "select last_insert_id()", keyProperty = "id", before = false, resultType = Integer.class)
     * @param userEntity
     */
    @Insert("INSERT INTO user(name, age, sex) " +
            "VALUES(#{name}, #{age}, #{sex})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertUser(UserEntity userEntity);

    @Update("update user set name = #{name} where id = #{id}")
    void updateUser(UserEntity userEntity);

    @Delete("delete from user where id = #{id}")
    void deleteUser(long id);

}
