package com.tms.mcq.domain.mcq;

import com.tms.mcq.domain.AggregatesRoot;
import com.tms.shared.UserRef;

import java.util.Set;

public class Reviewer extends AggregatesRoot {
    private UserRef reviewerId;
    private Set<String> subjects;
    private Set<String> topics;

}
