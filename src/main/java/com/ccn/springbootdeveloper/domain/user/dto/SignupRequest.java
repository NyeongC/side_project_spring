package com.ccn.springbootdeveloper.domain.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class SignupRequest {

    @NotBlank(message = "아이디는 필수입니다.")
    private String username;

    @NotBlank(message = "비밀번호는 필수입니다.")
    private String password;

    @Email(message = "이메일 형식이 올바르지 않습니다.")
    @NotBlank(message = "이메일은 필수입니다.")
    private String email;

    @Min(value = 0, message = "나이는 0 이상이어야 합니다.")
    private int age;
}