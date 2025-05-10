package com.example.clim_be.domain.admin.exception;

import com.example.clim_be.global.error.exception.ClimException;
import com.example.clim_be.global.error.exception.ErrorCode;

public class AdminAlreadyExistException extends ClimException {
    public static final ClimException EXCEPTION = new AdminAlreadyExistException();

    private AdminAlreadyExistException() {
        super(ErrorCode.ADMIN_ALREADY_EXIST);
    }
}
