package com.jerico.jmall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jerico.jmall.dao.UserDAO;
import com.jerico.jmall.dao.UserMapper;
import com.jerico.jmall.domain.dto.UserDTO;
import com.jerico.jmall.domain.entity.UserEntity;
import com.jerico.jmall.service.UserService;
import org.springframework.beans.BeanUtils;
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
    UserDAO userDAO;

    @Autowired
    UserMapper userMapper;

    @Override
    public PageInfo<UserEntity> listUsers(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        // 调用注解版
        List<UserEntity> listUsers = userDAO.listUsersA();
        // 调用xml版
        //List<UserEntity> listUsers = userMapper.listUsers();
        PageInfo<UserEntity> pageInfo = new PageInfo<>(listUsers);
        return pageInfo;
    }

    @Override
    public UserDTO getUser(long id) {
        UserDTO userDTO = new UserDTO();
        UserEntity userEntity = userDAO.getUserById(id);
        BeanUtils.copyProperties(userEntity, userDTO);
        return userDTO;
    }

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userDTO, userEntity);
        userDAO.insertUser(userEntity);
        BeanUtils.copyProperties(userEntity, userDTO);
        return userDTO;
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userDTO, userEntity);
        userDAO.updateUser(userEntity);
        BeanUtils.copyProperties(userEntity, userDTO);
        return userDTO;
    }

    @Override
    public void removeUser(long id) {
        userDAO.deleteUser(id);
    }
}
