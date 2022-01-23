package com.tms.mcq.domain.mcq;

import com.tms.mcq.domain.ValueObject;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode
public class Option extends ValueObject {

    private String optionText;

    private boolean isAns;

    public static Option of(String optionText, boolean ans) {
        return new Option(optionText, ans);
    }
}
