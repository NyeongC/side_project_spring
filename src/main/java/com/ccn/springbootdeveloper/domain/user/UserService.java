package com.ccn.springbootdeveloper.domain.user;


import com.ccn.springbootdeveloper.domain.user.dto.SignupRequest;
import com.ccn.springbootdeveloper.exception.DuplicateEmailException;
import com.ccn.springbootdeveloper.exception.DuplicateUsernameException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void signup(SignupRequest request) {

        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new DuplicateUsernameException();
        }

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new DuplicateEmailException();
        }

        String encodedPassword = passwordEncoder.encode(request.getPassword());

        User user = new User(
                request.getUsername(),
                request.getEmail(),
                encodedPassword,
                request.getAge()
        );

        userRepository.save(user);
    }
}