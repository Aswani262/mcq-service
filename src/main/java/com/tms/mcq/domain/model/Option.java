package com.tms.mcq.domain.model;

import lombok.Value;

@Value
public class Option extends ValueObject {
    private int seqId;
    private String optionText;
    private boolean isAns;

    public static Option of(int seqId, String optionText, boolean ans) {
        return new Option(seqId,optionText,ans);
    }
}
