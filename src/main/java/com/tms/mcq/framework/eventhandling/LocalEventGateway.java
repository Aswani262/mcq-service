package com.tms.mcq.framework.eventhandling;

import org.apache.camel.ProducerTemplate;

import java.util.List;


public class LocalEventGateway implements EventGateway {
    public ProducerTemplate producerTemplate;

    public LocalEventGateway(ProducerTemplate producerTemplate) {
        this.producerTemplate = producerTemplate;
    }

    @Override
    public void publish(List<DomainEvent> domainEvents) {
        domainEvents.stream().forEach(domainEvent -> {
            producerTemplate.sendBody("seda:" + domainEvent.getClass().getSimpleName(), domainEvent);
        });
    }

    @Override
    public void publish(DomainEvent domainEvent) {

    }
}
