package com.tms.mcq.framework.dto;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class UseCaseResult {
    Map<String,Object> result = new HashMap<String,Object>();

    public void addError(String code, String message){
        result.put("error","");
    }
    public void addData(Object data){
        result.put("data","");
    }
}
