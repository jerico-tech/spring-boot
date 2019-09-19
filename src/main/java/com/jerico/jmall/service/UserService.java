package com.jerico.jmall.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.jerico.jmall.domain.entity.UserEntity;

/**
 * @className: UserService
 * @description:
 * @author: jerico
 * @date: 2019-09-19 01:12
 * @version:
 */
public interface UserService {
    PageInfo<UserEntity> listUsers(int pageNum, int pageSize);

    UserEntity insertUser(UserEntity userEntity);
}
