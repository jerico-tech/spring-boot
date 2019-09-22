package com.jerico.jmall.controller;

import com.github.pagehelper.PageInfo;
import com.jerico.jmall.domain.dto.UserDTO;
import com.jerico.jmall.domain.entity.UserEntity;
import com.jerico.jmall.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @className: UserController
 * @description: 用户接口
 * @author: jerico
 * @date: 2019-09-13 00:36
 * @version:
 */
@Api(tags = "用户接口", value = "用户接口controller")
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "hello方法", notes = "用于测试")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "名称", required = true, paramType = "path"),
            @ApiImplicitParam(name = "id", value = "账号", required = true, dataType = "Integer", paramType = "path")
    })
    @ApiResponses({
            @ApiResponse(code = 400, message = "参数不正确 ")
    })
    @RequestMapping(value = "hello/{name}/{id}", method = RequestMethod.GET)
    public String index(@PathVariable("name") String name, @PathVariable("id") Integer id) {
        return "hello world!" + name + "/" + id;
    }


    /**
     * 分页获取用户集合，如果不传分页参数，使用默认值offset=0和limit=100
     */
    @ApiOperation(value = "获取用户列表", notes = "获取全部用户信息")
    @GetMapping()
    public ResponseEntity<PageInfo<UserEntity>> listUsers(@RequestParam(value = "offset", required = false,
            defaultValue = "0") int offset, @RequestParam(value = "limit", required = false, defaultValue = "100") int limit) {
        PageInfo<UserEntity> pageInfo = userService.listUsers(offset, limit);
        return new ResponseEntity<>(pageInfo, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable("id") long id) {
        UserDTO userDTO = userService.getUser(id);
        return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
    }


    @ApiOperation(value = "创建用户")
    @PostMapping()
    public ResponseEntity<UserDTO> saveUser(UserDTO userDTO) {
        UserDTO user = userService.saveUser(userDTO);
        return new ResponseEntity<UserDTO>(user, HttpStatus.CREATED);
    }

    @ApiOperation(value = "全量更新用户信息")
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable("id") long id, UserDTO userDTO) {
        userDTO.setId(id);
        UserDTO user = userService.updateUser(userDTO);
        return new ResponseEntity<UserDTO>(user, HttpStatus.CREATED);
    }

    @ApiOperation(value = "删除用户")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(long id) {
        userService.removeUser(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
