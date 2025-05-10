package com.example.clim_be.domain.user.exception;

import com.example.clim_be.global.error.exception.ClimException;
import com.example.clim_be.global.error.exception.ErrorCode;

public class UserNotFoundException extends ClimException {
    public static final ClimException EXCEPTION = new UserNotFoundException();

    private UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
