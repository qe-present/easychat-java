package com.easychat.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serializable;

@Data
@Schema(description = "登录时传递的数据模型")
public class RegisterDto implements Serializable {

    @Schema(description = "验证码")
    @NotEmpty(message = "验证码不能为空")
    private String code;

    @NotEmpty(message = "用户名不能为空")
    @Schema(description = "用户名")
    private String nickname;


    @NotEmpty(message = "密码不能为空")
    @Schema(description = "密码")
    private String password;

    @Schema(description = "邮箱")
    @Email(message = "邮箱格式不正确")
    @NotEmpty(message = "邮箱不能为空")
    private String email;


    @NotEmpty(message = "验证码key不能为空")
    @Schema(description = "验证码key")
    private String checkCodeKey;

}
