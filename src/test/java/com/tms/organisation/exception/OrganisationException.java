package com.tms.organisation.exception;

public class OrganisationException extends RuntimeException {

    private String code;
    private String message;
    private String causeInfo;
    public OrganisationException(String code, String message, String causeInfo) {

        //TODO: Need to append case info in message
       super(message);
       this.causeInfo = causeInfo;
       this.code = code;
       this.message = message;
    }

    public OrganisationException(String code, String message) {
       this(code,message,"Unknown");
    }

}
