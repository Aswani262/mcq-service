package com.tms.mcq.adaptors.in.restapi.cmd;

import com.tms.mcq.application.ports.in.commands.InitNewMCQCmd;
import com.tms.mcq.framework.commandhandling.CommandGateway;
import com.tms.mcq.framework.dto.RestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Business use case - When the user click of add new question , in backend will call this
 * api to assign the questionId to the new question. After that user can add other details to the
 * question
 * API - This will create a MCQ question in system with new unique MCQ Id and SubjectId
 * Subject is validated with master data service before creating the MCQ.
 * @See GeneratedId , SequenceService
 */

@RestController
@RequestMapping("/mcq/init")
public class InitMCQController {
    CommandGateway commandGateway ;

    public InitMCQController(CommandGateway commandGateway){
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public CompletableFuture<ResponseEntity<RestResponse>> initMCQ(@RequestBody Map<String,Object> req){
        InitNewMCQCmd cmd = InitNewMCQCmd.from(req);
        return commandGateway.sendAndReceiveAsync(cmd).thenApplyAsync(cmdResult -> new ResponseEntity<>(new RestResponse(cmdResult), HttpStatus.ACCEPTED));
    }

}
