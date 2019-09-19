package com.jerico.jmall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jerico.jmall.dao.UserDao;
import com.jerico.jmall.domain.entity.UserEntity;
import com.jerico.jmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @className: UserServiceImpl
 * @description:
 * @author: jerico
 * @date: 2019-09-19 01:12
 * @version:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public PageInfo<UserEntity> listUsers(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<UserEntity> listUsers = userDao.listUsers();
        PageInfo<UserEntity> pageInfo = new PageInfo<>(listUsers);
        return pageInfo;
    }

    @Override
    public UserEntity insertUser(UserEntity userEntity) {
        userDao.insert(userEntity);
        return userEntity;
    }
}
