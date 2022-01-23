package com.tms.mcq.domainevents;


import com.tms.shared.UserRef;
import lombok.Data;

import java.util.List;

@Data
public class MCQAssignedToApprover extends MCQApprovalProcessEvent{
    private String mcqId;
    private List<UserRef> assignedTos;

    public static MCQAssignedToApprover of(final String mcqId, final List<UserRef> assignedTos){
        MCQAssignedToApprover event = new MCQAssignedToApprover();
        event.mcqId = mcqId;
        event.assignedTos = assignedTos;
        return event;
    }
}
