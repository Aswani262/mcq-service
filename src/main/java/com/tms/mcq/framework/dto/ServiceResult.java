package com.tms.mcq.framework.dto;

import com.tms.mcq.framework.utils.ResponseKey;
import com.tms.mcq.framework.exception.*;
import com.tms.mcq.framework.utils.MessageCode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class ServiceResult {
    private Map<String,Object> data = new HashMap<>();
    private Map<String,Object> errors = new HashMap<>();

    public void addData(ResponseKey key,Object data){
        this.data.put(key.toString(),data);
    }

    public void addError(ErrorCode code,String message){
        this.errors.put(code.toString(),message);
    }
}
