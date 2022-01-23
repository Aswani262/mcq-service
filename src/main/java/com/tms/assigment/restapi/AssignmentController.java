package com.tms.assigment.restapi;

import com.tms.assigment.restapi.req.CreateNewAssignmentReq;
import com.tms.assigment.usecase.CreateNewAssigmentUseCase;
import com.tms.framework.commandhandling.Dispatcher;
import com.tms.framework.dto.ServiceResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RequestMapping("/assignment")
@RestController
public class AssignmentController {

    Dispatcher dispatcher;

    public AssignmentController(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    @PostMapping("/create")
    public CompletableFuture<ResponseEntity<ServiceResult>> createNewAssignment(@RequestBody CreateNewAssignmentReq req) {
        CreateNewAssigmentUseCase.CreateNewAssigment cmd = CreateNewAssigmentUseCase.CreateNewAssigment.from(req);
        return dispatcher.sendAndReceiveAsync(cmd).thenApplyAsync(cmdResult -> new ResponseEntity<>(cmdResult, HttpStatus.ACCEPTED));
    }
}
