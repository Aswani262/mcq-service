package com.tms.mcq.framework.restutils;

import com.tms.mcq.framework.utils.APIResponseBuilder;
import com.tms.mcq.framework.commandhandling.CommandResult;
import com.tms.mcq.framework.dto.RestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class RestResponseBuilder implements APIResponseBuilder {

    public static  ResponseEntity<RestResponse> build(CommandResult commandResult) {
        ResponseEntity<RestResponse> response = new ResponseEntity<RestResponse>(new RestResponse(commandResult), HttpStatus.ACCEPTED);
        return response;
    }
}
