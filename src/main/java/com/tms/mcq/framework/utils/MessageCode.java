package com.tms.mcq.framework.utils;


public enum MessageCode {
    MCQ_10001("Org Code is mandatory"),
    MCQ_10002("Subject is mandatory"),
    MCQ_10003("Unable to create new mcq question"),
    MCQ_10005("MCQ Question created successfully");

    private String defaultMessage;

    private MessageCode(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }
}