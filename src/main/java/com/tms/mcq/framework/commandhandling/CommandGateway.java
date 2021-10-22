package com.tms.mcq.framework.commandhandling;

import java.util.concurrent.CompletableFuture;

public interface CommandGateway {
     CompletableFuture<CommandResult> sendAndReceive(Command command);
}
