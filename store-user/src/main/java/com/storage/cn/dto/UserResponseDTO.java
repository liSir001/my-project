package com.storage.cn.dto;

import com.storage.cn.entity.User;
import com.storage.cn.util.BeanCopyUtils;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * @Auther: Lei Li
 * @Date: 2019/11/9 19:28
 * @Version 1.0
 */
@Data
public class UserResponseDTO extends BaseDTO {

    private Long id;

    private String userName;

    private String password;

    private String phone;

    private String email;

    public static UserResponseDTO build(User user) {
        UserResponseDTO dto = new UserResponseDTO();
        BeanCopyUtils.copyProperties(user, dto);
        return dto;
    }
}
