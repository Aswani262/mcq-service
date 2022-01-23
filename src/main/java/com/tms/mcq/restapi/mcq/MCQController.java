package com.tms.mcq.restapi.mcq;

import com.tms.framework.commandhandling.Dispatcher;
import com.tms.framework.dto.RestResponse;
import com.tms.framework.dto.ServiceResult;
import com.tms.mcq.restapi.mcq.req.*;
import com.tms.mcq.usecase.mcq.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/mcq")
public class MCQController {

    Dispatcher dispatcher;

    public MCQController(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    @PostMapping("/init")
    public CompletableFuture<ResponseEntity<ServiceResult>> initMCQ(@RequestBody InitNewMCQReq req) {
        InitMCQUseCase.InitNewMCQCmd cmd = InitMCQUseCase.InitNewMCQCmd.from(req);
        return dispatcher.sendAndReceiveAsync(cmd).thenApplyAsync(cmdResult -> new ResponseEntity<>(cmdResult, HttpStatus.ACCEPTED));
    }

    @PutMapping("/assign/label/{mcqId}")
    public CompletableFuture<ResponseEntity<RestResponse>> assignLabel(@PathVariable("mcqId") String mcqId, @RequestBody AssignLabelReq request) {
        AssignLabelUseCase.AssignLabel cmd = AssignLabelUseCase.AssignLabel.from(mcqId, request.getLabel());
        CompletableFuture<ServiceResult> completableFuture = dispatcher.sendAndReceiveAsync(cmd);
        return completableFuture.thenApplyAsync(cmdResult -> new ResponseEntity<>(new RestResponse(cmdResult), HttpStatus.ACCEPTED));
    }

    @DeleteMapping("/remove/label/{mcqId}")
    public CompletableFuture<ResponseEntity<RestResponse>> unAssignLabel(@PathVariable("mcqId") String mcqId, @RequestBody UnAssignLabelReq request) {
        RemovedAssignedLabelUseCase.UnAssingLable cmd = RemovedAssignedLabelUseCase.UnAssingLable.from(mcqId, request.getLabel());
        CompletableFuture<ServiceResult> completableFuture = dispatcher.sendAndReceiveAsync(cmd);
        return completableFuture.thenApplyAsync(cmdResult -> new ResponseEntity<>(new RestResponse(cmdResult), HttpStatus.ACCEPTED));
    }

    @PutMapping("/assign/topic/{mcqId}")
    public CompletableFuture<ResponseEntity<RestResponse>> assignTopic(@PathVariable("mcqId") String mcqId, @RequestBody String topic) {
        AssignTopicUseCase.AssignTopic cmd = AssignTopicUseCase.AssignTopic.from(mcqId, topic);
        CompletableFuture<ServiceResult> completableFuture = dispatcher.sendAndReceiveAsync(cmd);
        return completableFuture.thenApplyAsync(cmdResult -> new ResponseEntity<>(new RestResponse(cmdResult), HttpStatus.ACCEPTED));
    }

//    @DeleteMapping("/remove/topic/{mcqId}")
//    public CompletableFuture<ResponseEntity<RestResponse>> unAssignTopic(@PathVariable("mcqId") String mcqId, @RequestBody String topic) {
//        UnAssignTopic cmd = UnAssignTopic.from(mcqId, topic);
//        CompletableFuture<ServiceResult> completableFuture = dispatcher.sendAndReceiveAsync(cmd);
//        return completableFuture.thenApplyAsync(cmdResult -> new ResponseEntity<>(new RestResponse(cmdResult), HttpStatus.ACCEPTED));
//    }

    @PutMapping("/assign/year/{mcqId}")
    public CompletableFuture<ResponseEntity<RestResponse>> assignYear(@PathVariable("mcqId") String mcqId, @RequestBody String year) {
        AssignYearUseCase.AssignYearCmd cmd = AssignYearUseCase.AssignYearCmd.from(mcqId, year);
        CompletableFuture<ServiceResult> completableFuture = dispatcher.sendAndReceiveAsync(cmd);
        return completableFuture.thenApplyAsync(cmdResult -> new ResponseEntity<>(new RestResponse(cmdResult), HttpStatus.ACCEPTED));
    }

    @PutMapping("/remove/year/{mcqId}")
    public CompletableFuture<ResponseEntity<RestResponse>> unAssignYear(@PathVariable("mcqId") String mcqId, @RequestBody String year) {
        RemoveAssignedYearUseCase.UnAssignYearCmd cmd = RemoveAssignedYearUseCase.UnAssignYearCmd.from(mcqId, year);
        CompletableFuture<ServiceResult> completableFuture = dispatcher.sendAndReceiveAsync(cmd);
        return completableFuture.thenApplyAsync(cmdResult -> new ResponseEntity<>(new RestResponse(cmdResult), HttpStatus.ACCEPTED));
    }

    @PostMapping("/submit/{mcqId}")
    public CompletableFuture<ResponseEntity<ServiceResult>> submit(@PathVariable String mcqId) {
        SubmitMCQForApprovalUseCase.SubmitMCQ cmd = SubmitMCQForApprovalUseCase.SubmitMCQ.from(mcqId);
        return dispatcher.sendAndReceiveAsync(cmd).thenApplyAsync(cmdResult -> new ResponseEntity<>(cmdResult, HttpStatus.ACCEPTED));
    }

    @PutMapping("upsertHint/{mcqId}}")
    public CompletableFuture<ResponseEntity<RestResponse>> upsertHints(@PathVariable("mcqId") String mcqId, @RequestBody UpsertHintReq req) {
        UpsertHintUseCase.AddOrUpdateHintCmd cmd = UpsertHintUseCase.AddOrUpdateHintCmd.from(mcqId, req);
        CompletableFuture<ServiceResult> completableFuture =  dispatcher.sendAndReceiveAsync(cmd);
        return completableFuture.thenApplyAsync(cmdResult -> new ResponseEntity<>(new RestResponse(cmdResult), HttpStatus.ACCEPTED));
    }

    @PutMapping("upsert/{mcqId}")
    public CompletableFuture<ResponseEntity<RestResponse>> upsertOption(@PathVariable("mcqId") String mcqId, @RequestBody OptionsUpsertReq request) {
        UpsertOptionUseCase.UpsertOptionsCmd cmd = UpsertOptionUseCase.UpsertOptionsCmd.from(mcqId, request);
        CompletableFuture<ServiceResult> completableFuture = dispatcher.sendAndReceiveAsync(cmd);
        return completableFuture.thenApplyAsync(cmdResult -> new ResponseEntity<>(new RestResponse(cmdResult), HttpStatus.ACCEPTED));
    }
}
