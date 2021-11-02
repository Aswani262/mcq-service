package com.tms.mcq.framework.eventhandling;

import lombok.extern.log4j.Log4j2;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.ExchangeBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;


public class LocalEventGateway implements EventGateway {
   public ProducerTemplate producerTemplate;

   public LocalEventGateway(ProducerTemplate producerTemplate){
       this.producerTemplate = producerTemplate;
   }

    @Override
    public void publish(List<DomainEvent> domainEvents) {
        domainEvents.stream().forEach(domainEvent -> {
            producerTemplate.sendBody("seda:"+domainEvent.getClass().getSimpleName(),domainEvent);
        });
    }
}
