package com.tms.mcq.framework.exception;

import lombok.Data;

/**
 * Exception is categorized according to use case
 */
@Data
public class TMSException extends RuntimeException {
    private ErrorCode code;
    private boolean isRecoverable;
    private String causeInfo;

    public TMSException(String message) {
        super(message);
    }

    public TMSException(ErrorCode code, String message, String causeInfo) {
        super(message);
    }
}
