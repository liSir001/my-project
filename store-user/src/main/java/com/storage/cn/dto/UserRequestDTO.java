package com.storage.cn.dto;

import lombok.Data;
import com.storage.cn.validation.Create;
import com.storage.cn.validation.Update;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * @Auther: Lei Li
 * @Date: 2019/11/9 19:25
 * @Version 1.0
 */
@Data
public class UserRequestDTO {

    @Null(message = "创建用户，id应为空", groups = {Create.class})
    @NotNull(message = "更新用户，id不能为空", groups = {Update.class})
    private Long id;

    @NotBlank(message = "用户名不能为空")
    @Length(max = 50, message = "用户名长度不能大于50")
    private String userName;

    @NotBlank(message = "用户名不能为空")
    @Length(max = 50, message = "用户名长度不能大于50")
    private String password;

    @NotBlank(message = "手机号不能为空")
    @Length(max = 11, message = "手机号长度不能大于11")
    private String phone;

    @NotBlank(message = "邮箱不能为空")
    @Length(max = 50, message = "邮箱长度不能大于50")
    private String email;
}
