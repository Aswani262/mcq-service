package com.tms.mcq.framework.commandhandling;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class CommandResult {
    private StatusType status;
    private Map<String,HashMap<String,Object>> result;
    public void addResult(Map<String,HashMap<String,Object>> data){
        this.result = data;
        if(data.containsKey("error") && data.containsKey("data")){
            status = StatusType.PARTIAL_SUCCESS;
        } else if(data.containsKey("data") && !data.containsKey("error")){
            status = StatusType.SUCCESS;
        } else if(data.containsKey("error") && !data.containsKey("data")){
            status = StatusType.FAILED;
        };
    }

    public Object getData(String key){
       return   ((Map<String,Object>)result.get("data")).get(key);
    }

    public Map<String,Object> getError(){
       return(Map<String, Object>)result.get("error");
    }
}
