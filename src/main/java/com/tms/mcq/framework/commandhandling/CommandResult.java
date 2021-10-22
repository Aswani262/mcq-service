package com.tms.mcq.framework.commandhandling;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class CommandResult {
    private StatusType status;
    private Map<String,Object> result;

    public void addResult(Map<String,Object> data){
        this.result = data;
        if(data.containsKey("error") && data.containsKey("data")){
            status = StatusType.PARTIAL_SUCCESS;
        } else if(data.containsKey("data") && !data.containsKey("error")){
            status = StatusType.SUCCESS;
        } else if(data.containsKey("error") && !data.containsKey("data")){
            status = StatusType.FAILED;
        };
    }
}
