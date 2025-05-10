package com.example.clim_be.domain.user.application;

import com.example.clim_be.domain.auth.application.facade.UserFacade;
import com.example.clim_be.domain.user.domain.User;
import com.example.clim_be.domain.user.domain.repository.UserRepository;
import com.example.clim_be.domain.user.exception.UserNotFoundException;
import com.example.clim_be.domain.user.presentation.dto.request.InfoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserInfoService {
    private final UserFacade userFacade;
    private final UserRepository userRepository;

    @Transactional
    public void info(InfoRequest request) {
        User user = userRepository.findByAccountId(request.getAccountId())
                        .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        user.updateInfo(request.getRoomNumber(), request.getAlphabet());
    }

}
