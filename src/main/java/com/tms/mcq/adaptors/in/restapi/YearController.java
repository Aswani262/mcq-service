package com.tms.mcq.adaptors.in.restapi;

import com.tms.mcq.adaptors.in.restapi.req.OptionUpsertReq;
import com.tms.mcq.application.ports.in.commands.UpsertOptionCmd;
import com.tms.mcq.application.ports.in.commands.UpsertYearCmd;
import com.tms.mcq.framework.commandhandling.CommandGateway;
import com.tms.mcq.framework.commandhandling.CommandResult;
import com.tms.mcq.framework.dto.RestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RequestMapping("/mcq")
@RestController
public class YearController {

    CommandGateway commandGateway;

    public YearController(CommandGateway commandGateway){
        this.commandGateway = commandGateway;
    }

    @PutMapping("upsert/{mcqId}/year")
    public CompletableFuture<ResponseEntity<RestResponse>> upsertYear(@PathVariable("mcqId")String mcqId , @RequestBody String year)  {
        UpsertYearCmd cmd = UpsertYearCmd.from(mcqId,year);
        CompletableFuture<CommandResult> completableFuture = commandGateway.sendAndReceiveAsync(cmd);
        return completableFuture.thenApplyAsync(cmdResult -> new ResponseEntity<>(new RestResponse(cmdResult), HttpStatus.ACCEPTED));
    }

}
