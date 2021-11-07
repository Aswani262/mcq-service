package com.tms.mcq.framework.utils;

import com.tms.mcq.exception.MCQErrorCode;
import com.tms.mcq.exception.MCQException;

public class ServiceUtils {

    public static void handleException(Throwable throwable) {
        if (throwable.getClass().isAssignableFrom(MCQException.class)) {
            throw (MCQException) throwable;
            //TODO: Add other logic to identify recoverable error
        } else {
            throw new MCQException(MCQErrorCode.MCQ_10001, "Internal Server Error", throwable.getMessage());
        }
    }
}
