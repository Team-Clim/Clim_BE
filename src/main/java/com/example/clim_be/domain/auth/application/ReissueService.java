package com.example.clim_be.domain.auth.application;

import com.example.clim_be.domain.auth.domain.RefreshToken;
import com.example.clim_be.domain.auth.domain.repository.RefreshTokenRepository;
import com.example.clim_be.domain.auth.exception.InvalidTokenException;
import com.example.clim_be.domain.auth.presentation.dto.response.TokenResponse;
import com.example.clim_be.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReissueService {
    private final JwtTokenProvider jwtTokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;

    @Transactional
    public TokenResponse reissueToken(String token) {
        RefreshToken refreshToken = refreshTokenRepository.findByToken(token)
                .orElseThrow(()-> InvalidTokenException.EXCEPTION);

        return jwtTokenProvider.receiveToken(refreshToken.getId(), refreshToken.getRole());
    }
}
