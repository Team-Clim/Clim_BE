package com.example.clim_be.domain.cleaning.application;

import com.example.clim_be.domain.auth.application.facade.UserFacade;
import com.example.clim_be.domain.cleaning.domain.repository.CleaningRepository;
import com.example.clim_be.domain.cleaning.presentation.dto.response.CleaningResponse;
import com.example.clim_be.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QueryDateCleaningService {
    private final UserFacade userFacade;
    private final CleaningRepository cleaningRepository;

    @Transactional(readOnly = true)
    public Optional<CleaningResponse> execute() {
        User user = userFacade.currentUser();
        LocalDate today = LocalDate.now();

        return cleaningRepository.findCleaningStatusByDate(user.getUserName(), today);
    }
}
