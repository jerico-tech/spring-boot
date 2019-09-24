package com.jerico.jmall.dao;

import com.jerico.jmall.domain.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @className: UserMapper
 * @description:
 * @author: jerico
 * @date: 2019-09-22 22:47
 * @version:
 */
@Repository
public interface UserMapper {
    UserEntity getUser(long id);
    List<UserEntity> listUsers();
    void insetUser(UserEntity userEntity);
    void updateUser(UserEntity userEntity);
    void deleteUser(long id);

}
