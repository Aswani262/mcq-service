package com.tms.mcq.exception;

import com.tms.mcq.framework.exception.ErrorCode;
import com.tms.mcq.framework.exception.TMSException;
import lombok.Data;
import lombok.NoArgsConstructor;


public class MCQException extends TMSException {

    protected MCQException(String message){
        super(message);
    }
}
