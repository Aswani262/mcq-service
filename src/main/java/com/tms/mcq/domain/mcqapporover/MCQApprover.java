package com.tms.mcq.domain.mcqapporover;

import com.tms.mcq.domain.AggregatesRoot;
import com.tms.shared.UserRef;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Getter
@NoArgsConstructor
public class MCQApprover extends AggregatesRoot {
    private UserRef userId;
    private Set<String> subjects;
    private Set<String> topics;
}
