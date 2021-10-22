package com.tms.mcq.framework.exception;

import java.util.List;

public class MCQException extends TMSException {
    private ErrorCode code;
    private List<String> message;
    private ErrorType type;
}
