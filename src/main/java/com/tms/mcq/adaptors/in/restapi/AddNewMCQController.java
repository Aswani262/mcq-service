package com.tms.mcq.adaptors.in.restapi;

import com.tms.mcq.application.ports.in.AddNewMCQUseCase;
import com.tms.mcq.application.ports.in.commands.AddNewMCQCmd;
import com.tms.mcq.application.ports.in.commands.MCQCommand;
import com.tms.mcq.framework.commandhandling.Command;
import com.tms.mcq.framework.commandhandling.CommandGateway;
import com.tms.mcq.framework.commandhandling.CommandResult;
import com.tms.mcq.framework.dto.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/mcq")
public class AddNewMCQController {

    private CommandGateway commandGateway;

    public AddNewMCQController(CommandGateway commandGateway){
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public ResponseEntity<RestResponse> addNewMCQ(Map<String,Object> request) throws ExecutionException, InterruptedException {
        AddNewMCQCmd cmd = AddNewMCQCmd.from(request);
        cmd.toService("addNewMCQService");
        CommandResult commandResult = commandGateway.sendAndReceive(cmd).get();
        return new ResponseEntity<RestResponse>(new RestResponse(commandResult), HttpStatus.ACCEPTED);
    }
}
