package com.tms.mcq.eventsourcing;

public class DomainEventModel {
    private String eventId;
    private String aggregateId;
    private String eventType;
    private String payload;
    private int seq;
}
