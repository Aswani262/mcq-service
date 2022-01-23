package com.tms.mcq.domainevents;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class NewOptionAdded extends MCQUpdated {
    private String mcqId;
    private int optionSeqId;
    private String optionText;

    public static NewOptionAdded of(String mcqId, int seqId, String optionText) {
        NewOptionAdded evt = new NewOptionAdded(mcqId, seqId, optionText);
        return evt;
    }
}
