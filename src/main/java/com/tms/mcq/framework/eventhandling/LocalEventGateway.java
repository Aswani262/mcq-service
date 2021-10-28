package com.tms.mcq.framework.eventhandling;

import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.ExchangeBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LocalEventGateway implements EventGateway {

   public ProducerTemplate producerTemplate;

   private EventRegistry eventRegistry;

   public LocalEventGateway(ProducerTemplate producerTemplate,EventRegistry eventRegistry){
       this.producerTemplate = producerTemplate;
       this.eventRegistry = eventRegistry;
   }

    @Override
    public void publish(List<DomainEvent> domainEvents) {
        domainEvents.stream().forEach(domainEvent -> {
            producerTemplate.sendBody("seda:"+domainEvent.getClass().getSimpleName(),domainEvent);
        });
    }
}
