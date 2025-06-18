package com.example.clim_be.domain.cleaning.domain.repository;

import com.example.clim_be.domain.cleaning.presentation.dto.response.CleaningResponse;

import java.time.LocalDate;
import java.util.Optional;

public interface CleaningRepositoryCustom {
    Optional<CleaningResponse> findCleaningStatusByDate(String userName, LocalDate date);
}
