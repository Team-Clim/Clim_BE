package com.example.clim_be.domain.cleaning.presentation.dto.request;

import com.example.clim_be.domain.cleaning.domain.enums.CleaningStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class CleaningRequest {
    @NotNull
    private String userName;

    @NotNull
    private CleaningStatus cleaningStatus;

    private String reason;
}
