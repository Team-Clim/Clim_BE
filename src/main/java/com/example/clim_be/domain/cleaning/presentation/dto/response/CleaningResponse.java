package com.example.clim_be.domain.cleaning.presentation.dto.response;

import com.example.clim_be.domain.cleaning.domain.enums.CleaningStatus;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class CleaningResponse {
    private Integer roomNumber;

    private String userName;

    private CleaningStatus status;

    private String reason;

    private LocalDate date;
}
