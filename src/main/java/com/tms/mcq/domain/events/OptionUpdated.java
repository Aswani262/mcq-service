package com.tms.mcq.domain.events;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class OptionUpdated extends MCQUpdated {
    private String mcqId;
    private int optionSeqId;
    private String optionText;
    private boolean isAns;

    public static OptionUpdated of(String mcqId, int optionSeqId, String optionText, boolean isAns) {
        OptionUpdated evt = new OptionUpdated(mcqId, optionSeqId, optionText, isAns);
        return evt;
    }
}
