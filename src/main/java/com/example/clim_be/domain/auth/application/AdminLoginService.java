package com.example.clim_be.domain.auth.application;

import com.example.clim_be.domain.admin.domain.Admin;
import com.example.clim_be.domain.admin.domain.repository.AdminRepository;
import com.example.clim_be.domain.admin.exception.AdminNotFoundException;
import com.example.clim_be.domain.auth.presentation.dto.AuthElementDto;
import com.example.clim_be.domain.auth.exception.PasswordMismatchException;
import com.example.clim_be.domain.auth.presentation.dto.request.LoginRequest;
import com.example.clim_be.domain.auth.presentation.dto.response.TokenResponse;
import com.example.clim_be.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AdminLoginService {
    private final AdminRepository adminRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public TokenResponse login(LoginRequest request) {
        Admin admin = adminRepository.findByAccountId(request.getAccountId())
                .orElseThrow(() -> AdminNotFoundException.EXCEPTION);

        if (!passwordEncoder.matches(request.getPassword(), admin.getPassword())) {
            throw PasswordMismatchException.EXCEPTION;
        }

        return jwtTokenProvider.receiveToken(request.getAccountId(), AuthElementDto.Role.ADMIN);
    }
}
