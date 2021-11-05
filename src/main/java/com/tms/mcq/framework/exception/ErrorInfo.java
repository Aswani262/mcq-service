package com.tms.mcq.framework.exception;

import lombok.Data;

@Data
public class ErrorInfo {
    private String message;
    private String causeInfo;
    private ErrorCode code;
}
