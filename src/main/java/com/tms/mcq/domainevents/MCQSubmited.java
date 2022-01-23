package com.tms.mcq.domainevents;

import com.tms.mcq.domain.mcq.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MCQSubmited extends MCQUpdated{
    private String mcqId;
    private String status;

    public static MCQSubmited of(String mcqId, Status status) {
        MCQSubmited event = new MCQSubmited();
        event.mcqId = mcqId;
        event.status = status.toString();
        return event;
    }
}
