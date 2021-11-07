package com.tms.mcq.domain.events;

import lombok.Getter;

@Getter
public class NewHintAdded extends MCQUpdated {
    private String mcqId;
    private String hintText;

    private NewHintAdded(String mcqId, String hintText) {
        this.mcqId = mcqId;
        this.hintText = hintText;
    }

    public static NewHintAdded of(String mcqId, String hintText) {
        NewHintAdded evt = new NewHintAdded(mcqId, hintText);
        return evt;
    }
}
