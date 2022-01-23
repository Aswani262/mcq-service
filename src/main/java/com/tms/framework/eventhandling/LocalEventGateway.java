package com.tms.framework.eventhandling;

import org.apache.camel.ProducerTemplate;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
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
        publish(Collections.singletonList(domainEvent));
    }
}
