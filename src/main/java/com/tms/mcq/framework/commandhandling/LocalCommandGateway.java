package com.tms.mcq.framework.commandhandling;

import com.tms.mcq.framework.annotation.InfraService;
import com.tms.mcq.framework.dto.ServiceResult;
import org.apache.camel.ProducerTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@InfraService
public class LocalCommandGateway implements CommandGateway {

    ProducerTemplate producerTemplate;



    public LocalCommandGateway(ProducerTemplate template, CommandRegistry registry){
        this.producerTemplate = template;
    }

    @Override
    public CompletableFuture<CommandResult> sendAndReceiveAsync(Command command){
        return producerTemplate.asyncRequestBodyAndHeaders("seda:"+command.getClass().getSimpleName(),command,command.getHeaders(), ServiceResult.class).thenApply(result -> {
            CommandResult cmdResult = new CommandResult();
            cmdResult.addResult(result.getResult());
            return cmdResult;
        });

    }

    @Override
    public CommandResult sendAndReceive(Command command) {
         CommandResult commandResult = new CommandResult();

        try {
            commandResult =  producerTemplate.asyncRequestBodyAndHeaders("seda:"+command.getClass().getSimpleName(), command, command.getHeaders(), ServiceResult.class).thenApply(result -> {
                CommandResult cmdResult = new CommandResult();
                cmdResult.addResult(result.getResult());
                return cmdResult;
            }).get();
        } catch (InterruptedException e) {
            commandResult.addResult(new HashMap<>());
        } catch (ExecutionException e) {
            commandResult.addResult(new HashMap<>());
        }
        return commandResult;
    }
}
