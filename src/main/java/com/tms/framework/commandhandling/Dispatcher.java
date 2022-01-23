package com.tms.framework.commandhandling;

import com.tms.framework.dto.ServiceResult;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public interface Dispatcher {
    CompletableFuture<ServiceResult> sendAndReceiveAsync(Command command);

    ServiceResult sendAndReceive(Command command) throws ExecutionException, InterruptedException;
}
