package com.tms.framework.eventhandling;

import java.util.List;

public interface EventGateway {

    public void publish(List<DomainEvent> domainEvent);

    public void publish(DomainEvent domainEvent);
}
