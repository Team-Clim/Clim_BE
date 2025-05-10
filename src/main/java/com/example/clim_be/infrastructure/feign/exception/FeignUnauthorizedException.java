package com.example.clim_be.infrastructure.feign.exception;

import com.example.clim_be.global.error.exception.ClimException;
import com.example.clim_be.global.error.exception.ErrorCode;

public class FeignUnauthorizedException extends ClimException {

    public static final ClimException EXCEPTION = new FeignUnauthorizedException();

    private FeignUnauthorizedException(){
        super(ErrorCode.FEIGN_UNAUTHORIZED_EXCEPTION);
    }
}
