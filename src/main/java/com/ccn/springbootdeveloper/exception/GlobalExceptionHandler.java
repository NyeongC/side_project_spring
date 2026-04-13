package com.ccn.springbootdeveloper.exception;


import com.ccn.springbootdeveloper.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // username 중복
    @ExceptionHandler(DuplicateUsernameException.class)
    public ResponseEntity<ApiResponse<Void>> handleUsername() {
        return ResponseEntity
                .badRequest()
                .body(new ApiResponse<>(400, "이미 존재하는 username 입니다.", null));
    }

    // email 중복
    @ExceptionHandler(DuplicateEmailException.class)
    public ResponseEntity<ApiResponse<Void>> handleEmail() {
        return ResponseEntity
                .badRequest()
                .body(new ApiResponse<>(400, "이미 존재하는 email 입니다.", null));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<String>> handleValid(MethodArgumentNotValidException e) {

        String message = e.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .findFirst()
                .orElse("잘못된 요청입니다.");

        return ResponseEntity
                .badRequest()
                .body(new ApiResponse<>(400, message, null));
    }

    @ExceptionHandler(TodoNotFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleTodoNotFound() {
        return ResponseEntity
                .status(404)
                .body(new ApiResponse<>(404, "존재하지 않는 Todo 입니다.", null));
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleUserNotFound() {
        return ResponseEntity
                .status(404)
                .body(new ApiResponse<>(404, "존재하지 않는 User 입니다.", null));
    }
}