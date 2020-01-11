package com.xyz.swagger2demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "用户相关接口" )
public class Swagger2Controller {

    /**
     * 增加用户
     */
    @GetMapping("/add")
    @ApiOperation(value = "增加用户接口", notes = "根据URL中内容增加用户")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name="id" ,value="id"),
                    @ApiImplicitParam(name="name", value = "用户名" , defaultValue = "xyz"),
                    @ApiImplicitParam(name="address", value = "地址", defaultValue = "address_xyz")
            }
    )
    public String addUser(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("address") String address) {
        return "id:" + id + ",name:" + name + ",address:" + address;
    }

    /**
     * 根据ID更新用户
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "更新用户", notes = "根据用户ID更新用户信息")
    @ApiImplicitParam(name = "id", value = "用户ID",  required = true)
    public String updateUser(@PathVariable("id") int id) {
        return "id:" + id;
    }

    /**
     * 查询用户
     */
    @ApiOperation(value = "获取用户信息", notes = "获取所有用户信息")
    @GetMapping("/list")
    public String listUser() {
        return "userList";
    }

}
