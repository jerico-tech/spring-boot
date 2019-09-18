package com.jerico.jmall.controller;

import com.github.pagehelper.PageInfo;
import com.jerico.jmall.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;

/**
 * @className: UserController
 * @description:
 * @author: jerico
 * @date: 2019-09-13 00:36
 * @version:
 */
//@Api用在类上，说明该类的作用.tags；说明该类的作用；value：没太多意义。
@Api(tags = "用户接口", value = "用户接口controller")
@RestController
public class UserController {

    @Autowired
    UserService userService;
    /* @ApiOperation:用在请求的方法上，说明方法的作用. value:说明方法的作用； notes:方法的备注说明。
        @ApiImplicitParams: 用在请求的方法上，包含一组参数的说明
        @ApiImplicitParam：用在ApiImplicitParams注解中，指定一个请求参数的配置
            name: 参数名
            value: 参数的汉字说明、解释
            required: 参数是否必须传
            paramType: 参数放在哪个地方
                header --> 请求参数的获取：@RequestHeader
                query --> 请求参数的获取：@RequestParam
                path(用于restful接口) --> 请求参数的获取：@pathVariable
                body: 不常用
                form: 不常用
           dataType: 参数类型，默认String，其他值dataType="Integer"
           defaultValue: 参数的默认值
        @ApiResponses：用于请求的方法上，表示一组响应
        @ApiResponse：用在@ApiResponses中，一般用于表达一个错误的响应信息
            code：数字，例如400
            message：信息，例如"请求参数没填好"
            response：抛出异常的类
    */
    @ApiOperation(value = "hello方法", notes= "用于测试")
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

    public PageInfo listUser(int pageNum, int pageSize) {
        return userService.listUsers(pageNum, pageSize);
    }
}
