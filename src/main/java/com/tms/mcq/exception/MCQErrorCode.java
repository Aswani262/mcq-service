package com.tms.mcq.exception;

import com.tms.mcq.framework.exception.ErrorCode;
import org.springframework.http.HttpStatus;

public enum MCQErrorCode implements ErrorCode {
    //Command Validation - Start with 1
    MCQ_10001(HttpStatus.PRECONDITION_FAILED),
    MCQ_10002(HttpStatus.PRECONDITION_FAILED),
    MCQ_10003(HttpStatus.PRECONDITION_FAILED),
    MCQ_10004(HttpStatus.PRECONDITION_FAILED),
    MCQ_10005(HttpStatus.PRECONDITION_FAILED),
    MCQ_10006(HttpStatus.PRECONDITION_FAILED),
    MCQ_10007(HttpStatus.PRECONDITION_FAILED),
    MCQ_10008(HttpStatus.PRECONDITION_FAILED),
    MCQ_10009(HttpStatus.PRECONDITION_FAILED),
    MCQ_10010(HttpStatus.PRECONDITION_FAILED),
    MCQ_10011(HttpStatus.PRECONDITION_FAILED),
    MCQ_10012(HttpStatus.PRECONDITION_FAILED),
    MCQ_10013(HttpStatus.PRECONDITION_FAILED),
    MCQ_10014(HttpStatus.PRECONDITION_FAILED),
    MCQ_10015(HttpStatus.PRECONDITION_FAILED),
    //Business  Validation - Start with 2
    MCQ_20001(HttpStatus.NOT_FOUND),
    MCQ_20002(HttpStatus.NOT_FOUND),
    MCQ_20003(HttpStatus.NOT_FOUND);

    HttpStatus httpStatus;
    private MCQErrorCode(HttpStatus status){
        this.httpStatus = status;
    }


}
