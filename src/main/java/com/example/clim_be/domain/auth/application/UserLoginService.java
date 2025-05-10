package com.example.clim_be.domain.auth.application;

import com.example.clim_be.domain.auth.exception.PasswordMismatchException;
import com.example.clim_be.domain.auth.presentation.dto.AuthElementDto;
import com.example.clim_be.domain.auth.presentation.dto.request.LoginRequest;
import com.example.clim_be.domain.auth.presentation.dto.response.TokenResponse;
import com.example.clim_be.domain.user.domain.User;
import com.example.clim_be.domain.user.domain.repository.UserRepository;
import com.example.clim_be.domain.user.exception.UserNotFoundException;
import com.example.clim_be.global.security.jwt.JwtTokenProvider;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserLoginService {
    private final UserRepository userRepository;
    private final UserSignupService userSignupService;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public TokenResponse login(LoginRequest request) {
        boolean studentExists = userRepository.existsByAccountId(request.getAccountId());

        return studentExists
                ? loginExistingStudent(request)
                : userSignupService.registerAndLoginNewUser(request);
    }

    private TokenResponse loginExistingStudent(LoginRequest request) {
        User user = userRepository.findByAccountId(request.getAccountId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw PasswordMismatchException.EXCEPTION;
        }

        return jwtTokenProvider.receiveToken(
                String.valueOf(user.getId()),
                AuthElementDto.Role.BASIC
        );

    }
}
