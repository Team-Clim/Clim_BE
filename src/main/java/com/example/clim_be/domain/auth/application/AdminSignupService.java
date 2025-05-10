package com.example.clim_be.domain.auth.application;

import com.example.clim_be.domain.admin.domain.Admin;
import com.example.clim_be.domain.admin.domain.repository.AdminRepository;
import com.example.clim_be.domain.admin.exception.AdminAlreadyExistException;
import com.example.clim_be.domain.admin.presentation.dto.request.SignupRequest;
import com.example.clim_be.domain.auth.presentation.dto.AuthElementDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AdminSignupService {
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void execute(SignupRequest request) {

        if (adminRepository.existsByAccountId(request.getAccountId())) {
            throw AdminAlreadyExistException.EXCEPTION;
        }

        Admin admin = adminRepository.save(Admin.builder()
                        .userName(request.getUserName())
                        .accountId(request.getAccountId())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .role(AuthElementDto.Role.ADMIN)
                .build());
    }
}
