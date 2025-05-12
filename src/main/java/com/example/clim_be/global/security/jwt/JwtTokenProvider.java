package com.example.clim_be.global.security.jwt;

import com.example.clim_be.domain.auth.presentation.dto.AuthElementDto;
import com.example.clim_be.domain.auth.domain.repository.RefreshTokenRepository;
import com.example.clim_be.domain.auth.exception.InvalidTokenException;
import com.example.clim_be.domain.auth.presentation.dto.response.TokenResponse;
import com.example.clim_be.domain.user.domain.repository.UserRepository;
import com.example.clim_be.global.security.auth.CustomUserDetailsService;
import com.example.clim_be.domain.auth.domain.RefreshToken;
import com.example.clim_be.domain.auth.exception.ExpiredTokenException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {
    private final JwtProperties jwtProperties;
    private final UserRepository userRepository;
    private final CustomUserDetailsService customUserDetailsService;
    private final RefreshTokenRepository refreshTokenRepository;
    private static final String ACCESS_TOKEN = "access";
    private static final String REFRESH_TOKEN = "refresh";

    //access token 생성
    private String createAccessToken(String accountId, AuthElementDto.Role role) {

        Date now = new Date();

        return Jwts.builder()
                .setSubject(accountId)
                .claim(CLAIM_TYPE, ACCESS_TOKEN)
                .claim(CLAIM_USER_SECRET, getSecret(role))
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + toMillis(jwtProperties.getAccessExpiration())))
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey())
                .compact();
    }

    //refresh token 생성
    public String createRefreshToken(String accountId, AuthElementDto.Role role) {
        Date now = new Date();

        String refreshToken = Jwts.builder()
                .claim(CLAIM_TYPE, REFRESH_TOKEN)
                .claim(CLAIM_USER_SECRET, getSecret(role))
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + toMillis(jwtProperties.getRefreshExpiration())))
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey())
                .compact();


        refreshTokenRepository.save(
                RefreshToken.builder()
                        .role(role)
                        .accountId(accountId)
                        .token(refreshToken)
                        .timeToLive((jwtProperties.getRefreshExpiration()))
                        .build()
        );

        return refreshToken;
    }

    private String getSecret(AuthElementDto.Role role) {
        if (role.equals(AuthElementDto.Role.ADMIN)) {
            return jwtProperties.getAdminSecret();
        }

        return jwtProperties.getBasicSecret();
    }


    // 토큰에 담겨 있는 userId로 SpringSecurity Authentication 정보를 반환 하는 메서드
    public Authentication getAuthentication(String token) {
        Claims claims = getClaims(token);

        UserDetails userDetails = customUserDetailsService.loadUserByUsername(
                claims.getSubject() + ":" + claims.get("user")
        );

        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    private Claims getClaims(String token) {
        try {
            return Jwts
                    .parser()
                    .setSigningKey(jwtProperties.getSecretKey())
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            throw ExpiredTokenException.EXCEPTION;
        } catch (Exception e) {
            throw InvalidTokenException.EXCEPTION;
        }
    }

    public TokenResponse receiveToken(String accountId, AuthElementDto.Role role) {

        Date  now = new Date();

        return TokenResponse
                .builder()
                .accessToken(createAccessToken(accountId, role))
                .refreshToken(createRefreshToken(accountId, role))
                .accessExpiredAt(new Date(now.getTime() + jwtProperties.getAccessExpiration() * 1000))
                .refreshExpiredAt(new Date(now.getTime() + jwtProperties.getRefreshExpiration() * 1000))
                .build();

    }

    //HTTP 요청 헤더에서 토큰을 가져오는 메서드
    public String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(jwtProperties.getHeader());

        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(jwtProperties.getPrefix())
                && bearerToken.length() > jwtProperties.getPrefix().length() + 1) {
            return bearerToken.substring(7);
        }

        return null;
    }


}
