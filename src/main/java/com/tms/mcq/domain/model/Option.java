package com.tms.mcq.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Option extends ValueObject {
    @EqualsAndHashCode.Include
    private int seqId;

    private String optionText;

    private boolean isAns;

    public static Option of(int seqId, String optionText, boolean ans) {
        return new Option(seqId, optionText, ans);
    }
}
