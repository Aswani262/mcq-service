package com.tms.mcq.domainevents;

import lombok.Getter;

@Getter
public class HintUpdated extends MCQDomainEvent {
    private String mcqId;
    private String hintText;

    private HintUpdated(String mcqId, String hintText) {
        this.mcqId = mcqId;
        this.hintText = hintText;
    }

    public static HintUpdated of(String mcqId, String hintText) {
        HintUpdated evt = new HintUpdated(mcqId, hintText);
        return evt;
    }
}
