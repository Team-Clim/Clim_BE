package com.example.clim_be.domain.cleaning.application;

import com.example.clim_be.domain.admin.domain.Admin;
import com.example.clim_be.domain.auth.application.facade.AdminFacade;
import com.example.clim_be.domain.cleaning.domain.Cleaning;
import com.example.clim_be.domain.cleaning.domain.repository.CleaningRepository;
import com.example.clim_be.domain.cleaning.presentation.dto.request.CleaningRequest;
import com.example.clim_be.domain.user.domain.User;
import com.example.clim_be.domain.user.domain.repository.UserRepository;
import com.example.clim_be.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InputCleaningService {
    private final CleaningRepository cleaningRepository;
    private final AdminFacade adminFacade;
    private final UserRepository userRepository;

    @Transactional
    public void input(CleaningRequest request) {
        Admin admin = adminFacade.currentAdmin();

        User user = userRepository.findByUserName(request.getUserName())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        Cleaning cleaning = cleaningRepository.save(Cleaning.builder()
                        .user(user)
                        .status(request.getCleaningStatus())
                        .reason(request.getReason())
                        .date(request.getDate())
                .build());
    }
}
