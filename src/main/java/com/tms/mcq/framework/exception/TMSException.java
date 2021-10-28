package com.tms.mcq.framework.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class TMSException extends RuntimeException{
    private ErrorCode code;
    private List<MessageCode> messageCode;
    private ErrorType type;
    private boolean isRecoverable=true;

}
