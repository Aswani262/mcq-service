package com.tms.mcq.framework.eventhandling;

import com.tms.mcq.framework.exception.EventHandlingException;
import com.tms.mcq.framework.exception.GenericErrorCode;
import lombok.extern.log4j.Log4j2;
import org.apache.camel.ProducerTemplate;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
@Log4j2
public class KafkaDistributedEventGateway implements EventGateway {

    ProducerTemplate producerTemplate;

    KafkaDistributedEventGateway(ProducerTemplate template) {
        this.producerTemplate = template;
    }

    @Override
    public void publish(List<DomainEvent> domainEvents) {
        try {
            domainEvents.stream().forEach(domainEvent -> {
                String eventName = domainEvent.getClass().getSimpleName();
                producerTemplate.sendBodyAndHeader("kafka:mcq-cmd-domain-event?brokers=localhost:29092", domainEvent, "eventName", eventName);
            });
        } catch (Throwable throwable) {
            log.error(throwable);
            throw new EventHandlingException(GenericErrorCode.GEN_10001, "Error while publish exception", throwable.getMessage(), true);
        }
    }

    @Override
    public void publish(DomainEvent domainEvent) {
        this.publish(Collections.singletonList(domainEvent));
    }
}
