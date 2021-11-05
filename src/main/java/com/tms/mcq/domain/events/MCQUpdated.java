package com.tms.mcq.domain.events;

import com.tms.mcq.framework.eventhandling.DomainEvent;
import lombok.Getter;

import java.util.List;

@Getter
public class MCQUpdated extends DomainEvent{
    private String mcqId;

    private MCQUpdated(String mcqId){
        this.mcqId = mcqId;
    }

    public static MCQUpdated of(String mcqId) {
        MCQUpdated evt = new MCQUpdated(mcqId);
        return evt;
    }
}
