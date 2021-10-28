package com.tms.mcq.framework.commandhandling;

import java.util.concurrent.CompletableFuture;

public interface CommandGateway {
     CompletableFuture<CommandResult> sendAndReceiveAsync(Command command);
     CommandResult sendAndReceive(Command command);
}
