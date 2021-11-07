package com.tms.mcq.domain.events;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class NewOptionAdded extends MCQUpdated {
    private String mcqId;
    private int optionSeqId;
    private String optionText;
    private boolean isAns;

    public static NewOptionAdded of(String mcqId, int seqId, String optionText, boolean ans) {
        NewOptionAdded evt = new NewOptionAdded(mcqId, seqId, optionText, ans);
        return evt;
    }
}
