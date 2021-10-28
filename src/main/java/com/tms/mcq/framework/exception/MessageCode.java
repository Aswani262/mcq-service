package com.tms.mcq.framework.exception;

public enum MessageCode {
    MS_10001("Org Code is mandatory"),
    MS_10002("Subject is mandatory");

    private String defaultMessage;

    private MessageCode(String defaultMessage){
        this.defaultMessage = defaultMessage;
    }
}
