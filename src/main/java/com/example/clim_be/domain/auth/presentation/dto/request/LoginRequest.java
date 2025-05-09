package com.example.clim_be.domain.auth.presentation.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class LoginRequest {
    @NotNull
    private String accountId;

    @NotNull
    private String password;
}
