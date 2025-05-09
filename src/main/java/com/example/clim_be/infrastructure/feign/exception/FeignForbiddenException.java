package com.example.clim_be.infrastructure.feign.exception;

import com.example.clim_be.global.error.exception.ClimException;
import com.example.clim_be.global.error.exception.ErrorCode;

public class FeignForbiddenException extends ClimException {

    public static final ClimException EXCEPTION = new FeignForbiddenException();

    private FeignForbiddenException(){
        super(ErrorCode.FEIGN_FORBIDDDEN_EXCEPTION);
    }
}
