package com.jerico.spring.mybatis.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jerico.spring.mybatis.dao.UserDAO;
import com.jerico.spring.mybatis.entity.UserEntity;
import com.jerico.spring.mybatis.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @className: UserServiceImpl
 * @description:
 * @author: jerico
 * @date: 2020-03-15 21:36
 * @version:
 */
@Service
public class UserServiceImpl implements UserService {
  @Autowired UserDAO userDAO;

  @Override
  public UserEntity getUser(int id) {
    UserEntity result = userDAO.getUser(id);
    return result;
  }

  @Override
  public PageInfo<UserEntity> listUsers(int page, int size) {
    // 方式一 start
    // 将参数传给这个方法就可以实现物理分页了，非常简单
    PageHelper.startPage(page, size);
    List<UserEntity> userList = userDAO.listUsers();
    PageInfo<UserEntity> pageInfo = new PageInfo<>(userList);
    return pageInfo;
    // 方式一 end
    // 方式二（实现了分页却没有分页信息返回） start
    // 将参数传给这个方法就可以实现物理分页了，非常简单
//    PageHelper.startPage(page, size);
//    Page<UserEntity> pageResult = userDAO.listUsers();
//    return pageResult;
    // 方式二 end

  }

  @Override
  public UserEntity insertUser(UserEntity userEntity) {
    userDAO.insertUser(userEntity);
    return userEntity;
  }

  @Override
  public UserEntity updateUser(UserEntity userEntity) {
    userDAO.updateUser(userEntity);
    return userEntity;
  }

  @Override
  public void deleteUser(int id) {
    userDAO.deleteUser(id);
  }
}
