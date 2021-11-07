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
// Some thought on flow -
// Using CommandGateway - provide ayncExcecution of cammand , decouple Command from CommandHandler- means no need to
//                      - one service depend on other service in a direct way
//                      - provide a queue between Command Publisher and Command Excecutor/Consumer - So consumer will consume command
//                      - provide a great efficiny in handling the command.
// Using Reactive Way   - non-blocking and aync by nature - not need to provide extra code or handling
//                      - provide backpressure by default
//Using CommandGateway with Reactive


@RestController
@RequestMapping("/mcq")
public class QuestionTextController {

    CommandGateway commandGateway;

    public QuestionTextController(CommandGateway gateway) {
        this.commandGateway = gateway;
    }

    @PutMapping("upsert/{mcqId}/questionText")
    public CompletableFuture<ResponseEntity<RestResponse>> upsertQuestionText(@PathVariable("mcqId") String mcqId, @RequestBody UpsertQuestionTextReq request) {
        AddOrUpdateQuestionTextCmd cmd = AddOrUpdateQuestionTextCmd.from(mcqId, request.getQuestionText());
        CompletableFuture<CommandResult> completableFuture = commandGateway.sendAndReceiveAsync(cmd);
        return completableFuture.thenApplyAsync(cmdResult -> new ResponseEntity<>(new RestResponse(cmdResult), HttpStatus.ACCEPTED));
    }


}
