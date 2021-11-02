package com.tms.mcq.exception;

import com.tms.mcq.framework.exception.ErrorCode;
import lombok.NoArgsConstructor;


public class MCQIDGenerationException extends MCQException {

    protected MCQIDGenerationException(String message) {
        super(message);
    }

    public static MCQIDGenerationException from(ErrorCode code,String message,String causeInfo) {
        //Check code and message cannot be null
        MCQIDGenerationException ex = new MCQIDGenerationException(message);
        ex.setCauseInfo(causeInfo);
        ex.setCode(code);
        ex.setRecoverable(false);
        return ex;
    }

    public static MCQIDGenerationException from(ErrorCode code,String message) {
        //Check code and message cannot be null
        MCQIDGenerationException ex = new MCQIDGenerationException(message);
        ex.setCauseInfo("UNKNOWN");
        ex.setCode(code);
        ex.setRecoverable(false);
        return ex;
    }

    public static MCQIDGenerationException from(ErrorCode code,String message,boolean isRecoverable) {
        //Check code and message cannot be null
        MCQIDGenerationException ex = new MCQIDGenerationException(message);
        ex.setCauseInfo("UNKNOWN");
        ex.setCode(code);
        ex.setRecoverable(isRecoverable);
        return ex;
    }

    public static MCQIDGenerationException WithRecoveryDecision(ErrorCode code,String message,Throwable throwable) {
        //Check code and message cannot be null
        MCQIDGenerationException ex = new MCQIDGenerationException(message);
        ex.setCauseInfo(throwable.getMessage());
        ex.setCode(code);
        //Implement logic for recovery exception your are caching is recorerable or not
        ex.setRecoverable(false);
        return ex;
    }

    public static MCQIDGenerationException from(ErrorCode code,String message,String causeInfo,boolean isRecoverable) {
        //Check code and message cannot be null
        MCQIDGenerationException ex = new MCQIDGenerationException(message);
        ex.setCauseInfo(causeInfo);
        ex.setCode(code);
        ex.setRecoverable(isRecoverable);
        return ex;
    }
}
