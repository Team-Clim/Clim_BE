package com.example.clim_be.domain.user.presentation.dto.request;

import com.example.clim_be.domain.user.domain.enums.RoomAlphabet;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class InfoRequest {
    @NotNull
    private String accountId;

    @NotNull
    private Integer roomNumber;

    @NotNull
    private RoomAlphabet alphabet;
}
