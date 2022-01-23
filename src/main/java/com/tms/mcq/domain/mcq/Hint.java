package com.tms.mcq.domain.mcq;

import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode
public class Hint {
    private long hintId;
    @EqualsAndHashCode.Exclude
    private String text;
}
