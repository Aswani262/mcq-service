package com.tms.mcq.framework.exception;

public class EventHandlingException extends TMSException{


    public EventHandlingException(ErrorCode code,String message,String causeInfo,boolean isRecoverable) {
        super(message);
        setCode(code);
        setCauseInfo(causeInfo);
        setRecoverable(isRecoverable);
    }
}
