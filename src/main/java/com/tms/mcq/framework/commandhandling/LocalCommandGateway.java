package com.tms.mcq.framework.commandhandling;

import com.tms.mcq.framework.annotation.InfraService;
import com.tms.mcq.framework.dto.ServiceResult;
import com.tms.mcq.framework.exception.ErrorCode;
import lombok.extern.log4j.Log4j2;
import org.apache.camel.ProducerTemplate;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@InfraService
@Log4j2
public class LocalCommandGateway implements CommandGateway {

    ProducerTemplate producerTemplate;

    public LocalCommandGateway(ProducerTemplate template){
        this.producerTemplate = template;
    }

    @Override
    public CompletableFuture<CommandResult> sendAndReceiveAsync(Command command){
        return producerTemplate.asyncRequestBodyAndHeaders("seda:"+command.getClass().getSimpleName(),command,command.getHeaders(), ServiceResult.class).thenApply(result -> {
            CommandResult cmdResult = new CommandResult();
            cmdResult.setData(result.getData());
            cmdResult.setErrors(result.getErrors());
            return cmdResult;
        });
    }

    @Override
    public CommandResult sendAndReceive(Command command) {
        CommandResult commandResult = new CommandResult();
        try {
            commandResult =  producerTemplate.asyncRequestBodyAndHeaders("seda:"+command.getClass().getSimpleName(), command, command.getHeaders(), ServiceResult.class).thenApply(result -> {
                CommandResult cmdResult = new CommandResult();
                cmdResult.setData(result.getData());
                cmdResult.setErrors(result.getErrors());
                return cmdResult;
            }).get();
        } catch (InterruptedException | ExecutionException  e) {
        }
        return commandResult;
    }
}
