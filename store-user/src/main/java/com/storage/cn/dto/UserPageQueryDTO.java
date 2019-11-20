package com.storage.cn.dto;

import com.storage.cn.util.BeanCopyUtils;
import lombok.Data;
import com.storage.cn.entity.User;
import lombok.EqualsAndHashCode;
import org.springframework.beans.BeanUtils;

/**
 * @Auther: Lei Li
 * @Date: 2019/11/9 18:44
 * @Version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserPageQueryDTO extends BaseDTO {

    private Long id;

    private String userName;

    private String password;

    private String phone;

    private String email;

    public static UserPageQueryDTO build(User user) {
        UserPageQueryDTO dto = new UserPageQueryDTO();
        BeanCopyUtils.copyProperties(user, dto);
        return dto;
    }
}
