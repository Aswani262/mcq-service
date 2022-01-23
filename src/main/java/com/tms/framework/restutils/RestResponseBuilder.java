package com.tms.framework.restutils;

import com.tms.framework.commandhandling.CommandResult;
import com.tms.framework.dto.RestResponse;
import com.tms.framework.utils.APIResponseBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class RestResponseBuilder implements APIResponseBuilder {

    public static ResponseEntity<RestResponse> build(CommandResult commandResult) {
        ResponseEntity<RestResponse> response = new ResponseEntity<RestResponse>(new RestResponse(commandResult), HttpStatus.ACCEPTED);
        return response;
    }
}
