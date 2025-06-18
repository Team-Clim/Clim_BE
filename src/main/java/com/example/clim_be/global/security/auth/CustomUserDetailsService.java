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

        if (parts.length != 2) {
            throw InvalidTokenException.EXCEPTION;
        }

        var idPart = parts[0];
        var secret = parts[1];
        String type;

        try {
            if (secret.equals(jwtProperties.getAdminSecret())) {
                type = handleAdmin(idPart);
            } else if (secret.equals(jwtProperties.getBasicSecret())) {
                type = handleUser(Long.valueOf(idPart));
            } else {
                throw InvalidTokenException.EXCEPTION;
            }
        } catch (NumberFormatException e) {
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

    private String handleAdmin(String adminName) {
        if (!adminRepository.existsByUserName(adminName)) {
            throw AdminNotFoundException.EXCEPTION;
        }
        return AuthElementDto.Role.ADMIN.name();
    }

}
