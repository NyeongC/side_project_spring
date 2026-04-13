package com.ccn.springbootdeveloper.domain.user;

import com.ccn.springbootdeveloper.domain.user.dto.SignupRequest;
import com.ccn.springbootdeveloper.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<Void>> signup(@Valid @RequestBody SignupRequest request) {

        userService.signup(request);

        return ResponseEntity
                .status(201)
                .body(new ApiResponse<>(201, "회원가입 성공", null));
    }
}