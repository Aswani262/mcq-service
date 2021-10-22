package com.tms.mcq.framework.commandhandling;

import com.tms.mcq.framework.dto.UseCaseResult;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;


public class DistributedCommandGateway implements CommandGateway{

    ProducerTemplate producerTemplate;

    public DistributedCommandGateway(ProducerTemplate template){
        this.producerTemplate = template;
    }

    @Override
    public CompletableFuture<CommandResult> sendAndReceive(Command command){
        return producerTemplate.asyncRequestBodyAndHeaders("seda:microservicename-cmd",command,command.getHeaders(), UseCaseResult.class).thenApply(result -> {
            CommandResult cmdResult = new CommandResult();
            cmdResult.addResult(result.getResult());
            return cmdResult;
        });

    }


}
