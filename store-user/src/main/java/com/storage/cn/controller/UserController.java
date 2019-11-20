package com.storage.cn.controller;

import com.alibaba.fastjson.JSON;
import com.storage.cn.dto.UserPageQueryDTO;
import com.storage.cn.dto.UserRequestDTO;
import com.storage.cn.dto.UserResponseDTO;
import com.storage.cn.service.UserService;
import com.storage.cn.validation.Create;
import com.storage.cn.validation.Update;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.groups.Default;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * @Auther: Lei Li
 * @Date: 2019/11/9 18:04
 * @Version 1.0
 */
@Api(tags = "用户管理接口")
@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 创建用户
     *
     * @param userRequestDTO 用户实体
     * @return
     */
    @ApiOperation(value = "创建用户", produces = APPLICATION_JSON_UTF8_VALUE)
    @ApiImplicitParam(name = "userRequestDTO", value = "用户实体", required = true, paramType = "body", dataType = "UserRequestDTO")
    @PostMapping(produces = APPLICATION_JSON_UTF8_VALUE)
    public UserResponseDTO createUser(@Validated({Create.class, Default.class}) @RequestBody UserRequestDTO userRequestDTO) {
        log.info("Create user started, request:{}", JSON.toJSONString(userRequestDTO));
        UserResponseDTO user = userService.createUser(userRequestDTO);
        log.info("Create user finished, response:{}", JSON.toJSONString(user));
        return user;
    }

    /**
     * 分页查询用户列表
     *
     * @param userName 用户名
     * @param page     分页信息
     * @return
     */
    @ApiOperation(value = "分页查询用户列表", produces = APPLICATION_JSON_UTF8_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", dataType = "String"),
            @ApiImplicitParam(name = "page", value = "页码，从0开始", defaultValue = "0", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页大小", defaultValue = "20", dataType = "Integer", paramType = "query")
    })
    @GetMapping(path = "/page-query", produces = APPLICATION_JSON_UTF8_VALUE)
    public Page<UserPageQueryDTO> pageQueryUser(@RequestParam(value = "userName", required = false) String userName,
                                                @PageableDefault(value = 20, sort = {"id"}, direction = Sort.Direction.DESC) Pageable page) {
        log.info("Page query user started, userName:{}, page:{}", userName, page);
        Page<UserPageQueryDTO> userPageQueryDTOS = userService.pageQueryUser(userName, page);
        log.info("Page query user finished, response:{}", JSON.toJSONString(userPageQueryDTOS));
        return userPageQueryDTOS;
    }

    /**
     * 查询指定用户详情
     *
     * @param userId 用户id
     * @return
     */
    @ApiOperation(value = "查询指定用户详情", produces = APPLICATION_JSON_UTF8_VALUE)
    @ApiImplicitParam(name = "userId", value = "用户id", required = true, dataType = "Long")
    @GetMapping(path = "/detail/{userId}", produces = APPLICATION_JSON_UTF8_VALUE)
    public UserResponseDTO queryUserDetail(@PathVariable("userId") Long userId) {
        log.info("Query user detail started, userId:{}", userId);
        UserResponseDTO userResponseDTO = userService.queryUserByUserId(userId);
        log.info("Query user detail started, response:{}", JSON.toJSONString(userResponseDTO));
        return userResponseDTO;
    }

    /**
     * 删除指定用户
     *
     * @param userId 用户id
     */
    @ApiOperation(value = "删除指定用户", produces = APPLICATION_JSON_UTF8_VALUE)
    @ApiImplicitParam(name = "userId", value = "用户id", required = true, dataType = "Long")
    @DeleteMapping(path = "/{userId}", produces = APPLICATION_JSON_UTF8_VALUE)
    public void deleteUser(@PathVariable("userId") Long userId) {
        log.info("Delete user started, userId:{}", userId);
        userService.deleteUserByUserId(userId);
        log.info("Delete user finished, userId:{}", userId);
    }

    /**
     * 更新用户
     *
     * @param userRequestDTO 用户实体
     * @return
     */
    @ApiOperation(value = "更新用户", produces = APPLICATION_JSON_UTF8_VALUE)
    @ApiImplicitParam(name = "userRequestDTO", value = "用户实体", required = true, paramType = "body", dataType = "UserRequestDTO")
    @PutMapping(produces = APPLICATION_JSON_UTF8_VALUE)
    public UserResponseDTO updateUser(@Validated({Update.class, Default.class}) @RequestBody UserRequestDTO userRequestDTO) {
        log.info("Update user started, request:{}", JSON.toJSONString(userRequestDTO));
        UserResponseDTO user = userService.updateUser(userRequestDTO);
        log.info("Update user finished, response:{}", JSON.toJSONString(user));
        return user;
    }

    /**
     * 根据用户名和密码查询用户
     *
     * @param userName 用户名
     * @param password 密码
     */
    @ApiOperation(value = "登陆校验", produces = APPLICATION_JSON_UTF8_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String")
    })
    @GetMapping(path = "/verify", produces = APPLICATION_JSON_UTF8_VALUE)
    public Boolean verifyUser(@RequestParam("userName") String userName,
                              @RequestParam("password") String password) {
        log.info("Verify user started, userName:{}, password:{}", userName, password);
        Boolean success = userService.findUserByUserNameAndPassword(userName, password);
        log.info("Verify user finished");
        return success;
    }
}