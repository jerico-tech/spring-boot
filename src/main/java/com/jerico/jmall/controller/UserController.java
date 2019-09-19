package com.jerico.jmall.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.jerico.jmall.domain.entity.UserEntity;
import com.jerico.jmall.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/v1/user")
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
    @GetMapping("/users")
    public PageInfo<UserEntity> listUsers(@RequestParam(value = "offset", required = false, defaultValue = "0") int offset, @RequestParam(value = "limit", required = false, defaultValue = "100") int limit) {
        return userService.listUsers(offset, limit);
    }

    @PostMapping("/user")
    public UserEntity createUser(UserEntity userEntity) {
        return userService.insertUser(userEntity);
    }
}
