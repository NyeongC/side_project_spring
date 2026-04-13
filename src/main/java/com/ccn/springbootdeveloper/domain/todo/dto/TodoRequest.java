package com.ccn.springbootdeveloper.domain.todo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class TodoRequest {

    private String content;

    private Long userId;
}