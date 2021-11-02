package com.tms.mcq.framework.commandhandling;

import com.tms.mcq.framework.exception.ErrorCode;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class CommandResult {
    private StatusType status;
    private Map<String,Object> data = new HashMap<>();
    private Map<String,Object> errors = new HashMap<>();

    public void addError(ErrorCode code,String message){
        errors.put(code.toString(),message);
    }

}
