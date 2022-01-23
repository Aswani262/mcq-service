package com.tms.mcq.domain.subject;

import com.tms.mcq.domain.AggregatesRoot;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Subject extends AggregatesRoot {
    private String name;
    private String description;


}
