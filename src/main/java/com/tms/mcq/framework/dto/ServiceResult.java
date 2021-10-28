package com.tms.mcq.framework.dto;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class ServiceResult {
    private Map<String,HashMap<String,Object>> result;

    public ServiceResult(){
        result = new HashMap<>(2);
        result.put("data",new HashMap<String,Object>());
        result.put("error",new HashMap<String,Object>());
    }

    public void addData(String key,Object data){
        result.get("data").put(key,data);
    }

    public void addError(String code,String message){
        result.get("error").put(code,message);
    }
}
