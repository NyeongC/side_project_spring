package com.ccn.springbootdeveloper.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("존재하지 않는 User 입니다.");
    }
}