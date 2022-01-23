package com.tms.mcq.domainevents;

import com.tms.framework.eventhandling.DomainEvent;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class NewLabelAssigned extends MCQUpdated {
    private String mcqId;
    private String label;

    public static DomainEvent of(String mcqId, String label) {
        NewLabelAssigned evt = new NewLabelAssigned(mcqId, label);
        return evt;
    }
}
