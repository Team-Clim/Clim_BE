package com.example.clim_be.infrastructure.feign.exception;

import com.example.clim_be.global.error.exception.ClimException;
import com.example.clim_be.global.error.exception.ErrorCode;

public class FeignBadRequestException extends ClimException {

    public static final ClimException EXCEPTION = new FeignBadRequestException();

    private FeignBadRequestException(){
        super(ErrorCode.FEIGN_BAD_REQUEST);
    }
}
