package com.tms.framework.commandhandling;

import com.tms.framework.dto.ServiceResult;

import java.util.concurrent.CompletableFuture;


public class KafkaDistributedCommandGateway implements Dispatcher {

    @Override
    public CompletableFuture<ServiceResult> sendAndReceiveAsync(Command command) {
        return null;
    }

    @Override
    public ServiceResult sendAndReceive(Command command) {
        return null;
    }
}
