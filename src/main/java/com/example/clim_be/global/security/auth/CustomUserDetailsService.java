package com.example.clim_be.global.security.auth;

import com.example.clim_be.domain.admin.domain.repository.AdminRepository;
import com.example.clim_be.domain.admin.exception.AdminNotFoundException;
import com.example.clim_be.domain.auth.presentation.dto.AuthElementDto;
import com.example.clim_be.domain.auth.exception.InvalidTokenException;
import com.example.clim_be.domain.user.domain.repository.UserRepository;
import com.example.clim_be.domain.user.exception.UserNotFoundException;
import com.example.clim_be.global.security.jwt.JwtProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    private final AdminRepository adminRepository;
    private final JwtProperties jwtProperties;

    @Override
    public UserDetails loadUserByUsername(String accountId) {
        var parts = accountId.split(":");

        var userId = parts[0];
        var userSecretId = parts[1];
        String type;

        if (userSecretId.equals(jwtProperties.getAdminSecret())) {
            type = handleAdmin(Long.valueOf(userId));
        } else if (userSecretId.equals(jwtProperties.getBasicSecret())) {
            type = handleUser(Long.valueOf(userId));
        } else {
            throw InvalidTokenException.EXCEPTION;
        }

        return new CustomUserDetails(accountId, type);
    }

    private String handleUser(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw UserNotFoundException.EXCEPTION;
        }

        return AuthElementDto.Role.BASIC.name();
    }

    private String handleAdmin(Long adminId) {
        if (!adminRepository.existsById(adminId)) {
            throw AdminNotFoundException.EXCEPTION;
        }

        return AuthElementDto.Role.ADMIN.name();
    }
}
