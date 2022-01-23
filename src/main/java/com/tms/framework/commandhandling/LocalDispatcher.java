package com.tms.framework.commandhandling;

import com.tms.framework.annotation.InfraService;
import com.tms.framework.dto.ServiceResult;
import lombok.extern.log4j.Log4j2;
import org.apache.camel.ProducerTemplate;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@InfraService
@Log4j2
public class LocalDispatcher implements Dispatcher {

    ProducerTemplate producerTemplate;

    public LocalDispatcher(ProducerTemplate template) {
        this.producerTemplate = template;
    }

    @Override
    public CompletableFuture<ServiceResult> sendAndReceiveAsync(Command command) {
        return producerTemplate.asyncRequestBodyAndHeaders("seda:" + command.getClass().getSimpleName(), command, command.getHeaders(), ServiceResult.class);
    }

    @Override
    public ServiceResult sendAndReceive(Command command) throws ExecutionException, InterruptedException {
            return producerTemplate.asyncRequestBodyAndHeaders("seda:" + command.getClass().getSimpleName(), command, command.getHeaders(), ServiceResult.class).get();
    }
}
