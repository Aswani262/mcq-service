package com.tms.mcq.framework.commandhandling;

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
