package com.tms.mcq.domain.topic;

import com.tms.mcq.domain.AggregatesRoot;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Topic extends AggregatesRoot {
    String name;
    String description;
}
