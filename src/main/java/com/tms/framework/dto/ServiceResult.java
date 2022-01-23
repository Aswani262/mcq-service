package com.tms.framework.dto;

import com.tms.framework.exception.ErrorCode;
import com.tms.framework.utils.ResponseKey;
import com.tms.mcq.exception.MCQErrorCode;
import com.tms.mcq.exception.MCQException;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class ServiceResult {
    private Map<String, Object> data = new HashMap<>();
    private Map<String, Object> errors = new HashMap<>();

    public void addData(ResponseKey key, Object data) {
        this.data.put(key.toString(), data);
    }
    public Object getData(ResponseKey key) {
        return this.data.get(key);
    }

    public ServiceResult addError(ErrorCode code, String message) {
        this.errors.put("code", message);
        return this;
    }

    public ServiceResult addError(ErrorCode code, String message,String cause) {
        this.errors.put("code", message);
        this.errors.put("cause", cause);
        return this;
    }

    public void addError(Throwable th) {
        if(th.getClass().isAssignableFrom(MCQException.class)){
          MCQException exception =  (MCQException)th;
          //this.addError(exception.getCode(),exception.getMessage());
        } else {
            this.addError(MCQErrorCode.MCQ_500,"Internal Server Error",th.getCause().toString());
        }
    }

    public boolean isSuccess() {
        return this.errors.isEmpty();
    }

    public boolean isPartialSuccess() {
        return this.errors.isEmpty();
    }

    public void markSuccess() {

    }
}
