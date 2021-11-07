package com.tms.mcq.domain.events;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class LabelUnAssigned extends MCQUpdated {
    private String mcqId;
    private String labelCode;

    public static LabelUnAssigned of(String mcqId, String code) {
        LabelUnAssigned evt = new LabelUnAssigned(mcqId, code);
        return evt;
    }
}
