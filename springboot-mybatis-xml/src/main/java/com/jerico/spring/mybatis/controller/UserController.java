package com.jerico.spring.mybatis.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.jerico.spring.mybatis.entity.UserEntity;
import com.jerico.spring.mybatis.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: UserController
 * @description:
 * @author: jerico
 * @date: 2020-03-15 21:47
 * @version:
 */
@RestController
@Slf4j
@RequestMapping("/api/v1/users")
public class UserController {

  @Autowired UserService userService;

  @GetMapping("/{id}")
  public ResponseEntity<UserEntity> getUser(@PathVariable("id") int id) {
    UserEntity result = userService.getUser(id);
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<PageInfo<UserEntity>> listUsers(
      @RequestParam("page") int page, @RequestParam("size") int size) {
    PageInfo<UserEntity> result = userService.listUsers(page, size);
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<UserEntity> insertUser(@RequestBody UserEntity userEntity) {
    UserEntity result = userService.insertUser(userEntity);
    return new ResponseEntity<>(result, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<UserEntity> updateUser(@PathVariable("id")int id, UserEntity userEntity){
    UserEntity result = userService.updateUser(userEntity);
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity deleteUser(@PathVariable("id")int id){
    userService.deleteUser(id);
    return new ResponseEntity(HttpStatus.NO_CONTENT);
  }
}
