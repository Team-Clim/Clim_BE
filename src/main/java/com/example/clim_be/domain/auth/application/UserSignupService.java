package com.example.clim_be.domain.auth.application;

import com.example.clim_be.domain.auth.presentation.dto.AuthElementDto;
import com.example.clim_be.domain.auth.presentation.dto.request.LoginRequest;
import com.example.clim_be.domain.auth.presentation.dto.response.TokenResponse;
import com.example.clim_be.domain.user.domain.User;
import com.example.clim_be.domain.user.domain.repository.UserRepository;
import com.example.clim_be.global.security.jwt.JwtTokenProvider;
import com.example.clim_be.infrastructure.xquare.XquareClient;
import com.example.clim_be.infrastructure.xquare.dto.XquareUserResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserSignupService {
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final XquareClient xquareClient;

    @Transactional
    public TokenResponse registerAndLoginNewUser(LoginRequest request) {
        XquareUserResponse xquareUserResponse = xquareClient.xquareUser(request);

        User user = saveNewUser(xquareUserResponse);

        return jwtTokenProvider.receiveToken(
                String.valueOf(user.getId()),
                AuthElementDto.Role.BASIC
        );
    }

    private User saveNewUser(XquareUserResponse user) {
        User newUser = new User(
                user.getAccountId(),
                user.getPassword(),
                user.getName(),
                user.getRole(),
                user.getGrade(),
                user.getClassNum(),
                user.getNum()
        );
        return userRepository.save(newUser);
    }
}
