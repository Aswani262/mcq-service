package com.tms.mcq.adaptors.in.restapi;

import com.tms.mcq.adaptors.in.restapi.req.UpsertQuestionTextReq;
import com.tms.mcq.application.ports.in.commands.AddOrUpdateQuestionTextCmd;
import com.tms.mcq.framework.commandhandling.CommandGateway;
import com.tms.mcq.framework.commandhandling.CommandResult;
import com.tms.mcq.framework.dto.RestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/mcq")
public class LabelAssignController {

    CommandGateway commandGateway;

    public LabelAssignController(CommandGateway gateway) {
        this.commandGateway = gateway;
    }

    @PutMapping("assign/{mcqId}/label")
    public CompletableFuture<ResponseEntity<RestResponse>> assignTopic(@PathVariable("mcqId") String mcqId, @RequestBody UpsertQuestionTextReq request) {
        AddOrUpdateQuestionTextCmd cmd = AddOrUpdateQuestionTextCmd.from(mcqId, request.getQuestionText());
        CompletableFuture<CommandResult> completableFuture = commandGateway.sendAndReceiveAsync(cmd);
        return completableFuture.thenApplyAsync(cmdResult -> new ResponseEntity<>(new RestResponse(cmdResult), HttpStatus.ACCEPTED));
    }

    @DeleteMapping("unAssign/{mcqId}/label")
    public CompletableFuture<ResponseEntity<RestResponse>> unAssignTopic(@PathVariable("mcqId") String mcqId, @RequestBody UpsertQuestionTextReq request) {
        AddOrUpdateQuestionTextCmd cmd = AddOrUpdateQuestionTextCmd.from(mcqId, request.getQuestionText());
        CompletableFuture<CommandResult> completableFuture = commandGateway.sendAndReceiveAsync(cmd);
        return completableFuture.thenApplyAsync(cmdResult -> new ResponseEntity<>(new RestResponse(cmdResult), HttpStatus.ACCEPTED));
    }
}
