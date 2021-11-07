package com.tms.mcq.domain.events;

import com.tms.mcq.framework.eventhandling.DomainEvent;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class NewLabelAssigned extends MCQUpdated {
    private String mcqId;
    private String labelCode;


    public static DomainEvent of(String mcqId, String labelCode) {
        NewLabelAssigned evt = new NewLabelAssigned(mcqId, labelCode);
        return evt;
    }
}
