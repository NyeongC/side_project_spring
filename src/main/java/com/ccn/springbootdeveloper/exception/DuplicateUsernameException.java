package com.ccn.springbootdeveloper.exception;

public class DuplicateUsernameException extends RuntimeException {
    public DuplicateUsernameException() {
        super("이미 존재하는 username 입니다.");
    }
}