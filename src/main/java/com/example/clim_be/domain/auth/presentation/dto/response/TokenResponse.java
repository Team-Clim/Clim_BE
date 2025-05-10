package com.example.clim_be.domain.auth.presentation.dto.response;

import lombok.Builder;

import java.util.Date;

@Builder
public record TokenResponse(
        String accessToken,
        String refreshToken,
        Date accessExpiredAt,
        Date refreshExpiredAt
) {
}
