package com.tms.mcq.framework.exception;

public class CommandExcecutionException extends TMSException{
    public CommandExcecutionException(ErrorCode code, String message, boolean isRecoverable) {
        super(message);
    }
}
