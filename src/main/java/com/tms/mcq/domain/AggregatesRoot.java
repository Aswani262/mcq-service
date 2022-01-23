package com.tms.mcq.domain;

import com.tms.framework.eventhandling.DomainEvent;

import java.util.ArrayList;
import java.util.List;

public class AggregatesRoot extends ChangeHistory {
    private String id;
    private String tenetId;//Provide unique TenetId - TENT-0001

    private List<DomainEvent> domainEvents = new ArrayList<>();

    public void addEvent(DomainEvent dominEvent) {
        domainEvents.add(dominEvent);
    }

    public List<DomainEvent> getEvents() {
        return domainEvents;
    }

    public void clear(){
        this.domainEvents.clear();
    }
}
