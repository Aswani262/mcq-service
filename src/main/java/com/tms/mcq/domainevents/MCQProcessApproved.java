package com.tms.mcq.domainevents;

import com.tms.framework.eventhandling.DomainEvent;
import com.tms.mcq.domain.mcq.ProcessStatus;
import lombok.Data;

@Data
public class MCQProcessApproved extends MCQApprovalProcessEvent{
    private String mcqId;
    private ProcessStatus status;
    public static DomainEvent of(String mcqId, ProcessStatus status) {
        MCQProcessApproved event = new MCQProcessApproved();
        event.mcqId = mcqId;
        event.status = status;
        return event;
    }
}
