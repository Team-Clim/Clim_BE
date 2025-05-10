package com.example.clim_be.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ClimException extends RuntimeException {
    private final ErrorCode errorCode;
}
