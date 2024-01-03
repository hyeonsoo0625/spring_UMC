package com.example.UMC_spring.apiPayload.exception.handler;

import com.example.UMC_spring.apiPayload.code.BaseErrorCode;
import com.example.UMC_spring.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {
    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
