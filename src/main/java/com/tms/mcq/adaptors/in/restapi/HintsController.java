package com.tms.mcq.adaptors.in.restapi;

import com.tms.mcq.adaptors.in.restapi.req.UpsertHintReq;
import com.tms.mcq.application.ports.in.commands.AddOrUpdateHintCmd;
import com.tms.mcq.application.ports.in.commands.AddOrUpdateQuestionTextCmd;
import com.tms.mcq.application.ports.in.commands.RemoveHintCmd;
import com.tms.mcq.framework.commandhandling.CommandGateway;
import com.tms.mcq.framework.commandhandling.CommandResult;
import com.tms.mcq.framework.dto.RestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
@RestController
@RequestMapping("/mcq")
public class HintsController {

    CommandGateway commandGateway;

    public HintsController(CommandGateway gateway){
        this.commandGateway = gateway;
    }

    @PutMapping("upsert/{mcqId}/hint")
    public CompletableFuture<ResponseEntity<RestResponse>> upsertHints(@PathVariable("mcqId")String mcqId , @RequestBody UpsertHintReq req)  {
        AddOrUpdateHintCmd cmd = AddOrUpdateHintCmd.from(mcqId,req);
        CompletableFuture<CommandResult> completableFuture = commandGateway.sendAndReceiveAsync(cmd);
        return completableFuture.thenApplyAsync(cmdResult -> new ResponseEntity<>(new RestResponse(cmdResult), HttpStatus.ACCEPTED));
    }

    @DeleteMapping("remove/{mcqId}/hint/{seqId}")
    public CompletableFuture<ResponseEntity<RestResponse>> remove(@PathVariable("mcqId")String mcqId , @PathVariable("seqId") int seqId)  {
        RemoveHintCmd cmd = RemoveHintCmd.from(mcqId,seqId);
        CompletableFuture<CommandResult> completableFuture = commandGateway.sendAndReceiveAsync(cmd);
        return completableFuture.thenApplyAsync(cmdResult -> new ResponseEntity<>(new RestResponse(cmdResult), HttpStatus.ACCEPTED));
    }
}
