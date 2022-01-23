package com.tms.framework.commandhandling;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
public class Command  {
    private Map<String, Object> headers = new HashMap<>();

    public void addServiceAndMethod(String serviceName, String method) {
        headers.put("serviceName", serviceName);
        headers.put("methodName", method);
    }

    public String orgCode() {
        return "ABC";
    }
}
