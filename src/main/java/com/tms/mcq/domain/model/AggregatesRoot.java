package com.tms.mcq.domain.model;

import com.tms.mcq.framework.eventhandling.DomainEvent;

import java.util.ArrayList;
import java.util.List;

public class AggregatesRoot extends ChangeHistory{

    //used by persistence engine
    //Technical id
    private String id;

    public String getId(){
        return id;
    };

    private List<DomainEvent> domainEvents = new ArrayList<>();

    public void addEvent(DomainEvent dominEvent){
        domainEvents.add(dominEvent);
    }

    public List<DomainEvent> getEvents(){
        return domainEvents;
    }
}
