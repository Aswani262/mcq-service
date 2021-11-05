package com.tms.mcq.exception;

import com.tms.mcq.framework.exception.ErrorCode;
import com.tms.mcq.framework.exception.TMSException;
import lombok.Data;
import lombok.NoArgsConstructor;


public class MCQException extends TMSException {

    public MCQException(MCQErrorCode code,String message,String causeInfo){
        super(message);
        setCode(code);
        setCauseInfo(causeInfo);
    }
}
