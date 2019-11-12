package com.storage.cn.service;

import com.storage.cn.dto.UserPageQueryDTO;
import com.storage.cn.dto.UserRequestDTO;
import com.storage.cn.dto.UserResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    /**
     * 创建用户
     * @param userRequestDTO 用户实体
     * @return
     */
    UserResponseDTO createUser(UserRequestDTO userRequestDTO);

    /**
     * 分页查询用户列表
     * @param userName 用户名
     * @param page     分页信息
     * @return
     */
    Page<UserPageQueryDTO> pageQueryUser(String userName, Pageable page);

    /**
     * 查询指定用户详情
     * @param userId 用户id
     * @return
     */
    UserResponseDTO queryUserByUserId(Long userId);

    /**
     * 删除指定用户
     * @param userId 用户id
     */
    void deleteUserByUserId(Long userId);

    /**
     * 更新用户
     * @param userRequestDTO 用户实体
     * @return
     */
    UserResponseDTO updateUser(UserRequestDTO userRequestDTO);
}
