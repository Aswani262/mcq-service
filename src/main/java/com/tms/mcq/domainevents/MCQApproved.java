package com.tms.mcq.domainevents;

import com.tms.framework.eventhandling.DomainEvent;
import lombok.Data;

@Data
public class MCQApproved extends DomainEvent {
    private String mcqId;

    public static MCQApproved of(String mcqId) {
        MCQApproved event = new MCQApproved();
        event.mcqId = mcqId;
        return event;
    }
}
