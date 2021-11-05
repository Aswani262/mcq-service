package com.tms.mcq.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Value;

@Value
public class Hint {
    private int seqId;
    private String hintText;

    public static Hint of(int seqId, String hintText) {
        Hint hint = new Hint(seqId,hintText);
        return hint;
    }
}
