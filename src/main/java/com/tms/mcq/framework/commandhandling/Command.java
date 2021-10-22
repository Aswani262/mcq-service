package com.tms.mcq.framework.commandhandling;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
public class Command {
    private Map<String,Object> headers = new HashMap<>();

    public void toService(String value){
        headers.put("toBean",value);
    }


}
