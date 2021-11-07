package com.tms.mcq.adaptors.in.restapi;

import com.tms.mcq.adaptors.in.restapi.req.OptionUpsertReq;
import com.tms.mcq.application.ports.in.commands.UpsertOptionCmd;
import com.tms.mcq.framework.commandhandling.CommandGateway;
import com.tms.mcq.framework.commandhandling.CommandResult;
import com.tms.mcq.framework.dto.RestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/mcq")
public class OptionController {

    CommandGateway commandGateway;

    public OptionController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PutMapping("upsert/{mcqId}/option")
    public CompletableFuture<ResponseEntity<RestResponse>> upsertOption(@PathVariable("mcqId") String mcqId, @RequestBody OptionUpsertReq request) {
        UpsertOptionCmd cmd = UpsertOptionCmd.from(mcqId, request);
        CompletableFuture<CommandResult> completableFuture = commandGateway.sendAndReceiveAsync(cmd);
        return completableFuture.thenApplyAsync(cmdResult -> new ResponseEntity<>(new RestResponse(cmdResult), HttpStatus.ACCEPTED));
    }
}
