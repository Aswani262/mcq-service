package com.tms.mcq.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Hints {
    private String hindId;
    private int seqId;
    private String hintText;
}
