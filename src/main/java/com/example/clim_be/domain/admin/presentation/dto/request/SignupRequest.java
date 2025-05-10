package com.example.clim_be.domain.admin.presentation.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class SignupRequest {
    @NotNull
    private String accountId;

    @NotNull
    private String password;

    @NotNull
    private String userName;
}
