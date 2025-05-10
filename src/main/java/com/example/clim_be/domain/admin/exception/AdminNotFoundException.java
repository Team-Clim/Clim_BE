package com.example.clim_be.domain.admin.exception;

import com.example.clim_be.global.error.exception.ClimException;
import com.example.clim_be.global.error.exception.ErrorCode;

public class AdminNotFoundException extends ClimException {
    public static final ClimException EXCEPTION = new AdminNotFoundException();

    private AdminNotFoundException() {
        super(ErrorCode.ADMIN_NOT_FOUND);
    }
}
