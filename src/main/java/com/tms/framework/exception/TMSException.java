package com.tms.framework.exception;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * Exception is categorized according to use case
 */
@Data
public class TMSException extends RuntimeException {

    private Map<? extends ErrorCode,String> errorDetails ;
    private boolean isRecoverable;
    private String causeInfo;

    public TMSException(ErrorCode code, String message, String causeInfo) {
        super(message);
        errorDetails = new HashMap<>();
        //errorDetails.put(code,message);
        this.causeInfo = causeInfo;
    }

    public TMSException(Map<? extends ErrorCode,String> errors) {
        super(errors.toString());
        errorDetails = errors;
    }
}
