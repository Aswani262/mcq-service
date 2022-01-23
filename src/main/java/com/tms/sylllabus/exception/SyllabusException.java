package com.tms.sylllabus.exception;


public class SyllabusException extends RuntimeException{
    private String code;
    private String message;
    private String cause;

    public SyllabusException(String code,String message){
        super(message);
        this.message = message;
        this.code= code;
    }
    public SyllabusException(String code,String message,String cause){
        super(message);
        this.message = message;
        this.code= code;
        this.cause = cause;
    }
}
