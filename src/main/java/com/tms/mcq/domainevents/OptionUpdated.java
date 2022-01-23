package com.tms.mcq.domainevents;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class OptionUpdated extends MCQUpdated {
    private String mcqId;
    private int optionSeqId;
    private String optionText;

    public static OptionUpdated of(String mcqId, int optionSeqId, String optionText ) {
        OptionUpdated evt = new OptionUpdated(mcqId, optionSeqId, optionText);
        return evt;
    }
}
