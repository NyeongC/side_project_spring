package com.ccn.springbootdeveloper.exception;

public class TodoNotFoundException extends RuntimeException {
    public TodoNotFoundException() {
        super("존재하지 않는 Todo 입니다.");
    }
}