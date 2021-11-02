package com.tms.mcq.framework.commandhandling;

import com.tms.mcq.framework.eventhandling.DomainEvent;
import com.tms.mcq.framework.eventhandling.EventGateway;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CompletableFuture;


public class KafkaDistributedCommandGateway implements CommandGateway {

    @Override
    public CompletableFuture<CommandResult> sendAndReceiveAsync(Command command) {
        return null;
    }

    @Override
    public CommandResult sendAndReceive(Command command) {
        return null;
    }
}
