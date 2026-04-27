package com.ccn.springbootdeveloper.domain.user;

import com.ccn.springbootdeveloper.domain.user.dto.SignupRequest;
import com.ccn.springbootdeveloper.exception.DuplicateEmailException;
import com.ccn.springbootdeveloper.exception.DuplicateUsernameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    @Test
    @DisplayName("회원가입 성공 - 비즈니스 로직")
    void signup_success() {
        // given
        SignupRequest request = new SignupRequest("testuser", "password123", "test@test.com", 25);
        given(userRepository.findByUsername(request.getUsername())).willReturn(Optional.empty());
        given(userRepository.findByEmail(request.getEmail())).willReturn(Optional.empty());
        given(passwordEncoder.encode(request.getPassword())).willReturn("encodedPassword");

        // when
        userService.signup(request);

        // then
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    @DisplayName("회원가입 실패 - 중복된 username 예외 발생")
    void signup_fail_duplicate_username() {
        // given
        SignupRequest request = new SignupRequest("testuser", "password123", "test@test.com", 25);
        given(userRepository.findByUsername(request.getUsername())).willReturn(Optional.of(new User()));

        // when & then
        assertThrows(DuplicateUsernameException.class, () -> userService.signup(request));
    }

    @Test
    @DisplayName("회원가입 실패 - 중복된 email 예외 발생")
    void signup_fail_duplicate_email() {
        // given
        SignupRequest request = new SignupRequest("testuser", "password123", "test@test.com", 25);
        given(userRepository.findByUsername(request.getUsername())).willReturn(Optional.empty());
        given(userRepository.findByEmail(request.getEmail())).willReturn(Optional.of(new User()));

        // when & then
        assertThrows(DuplicateEmailException.class, () -> userService.signup(request));
    }
}