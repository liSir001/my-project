package com.storage.cn.service;

import com.storage.cn.dto.UserPageQueryDTO;
import com.storage.cn.dto.UserRequestDTO;
import com.storage.cn.dto.UserResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    /**
     * 创建用户
     * @param userRequestDTO
     * @return
     */
    UserResponseDTO registerUser(UserRequestDTO userRequestDTO);

    /**
     * 分页查询用户列表
     * @param userName 用户名
     * @param page     分页信息
     * @return
     */
    Page<UserPageQueryDTO> pageQueryUser(String userName, Pageable page);


}
