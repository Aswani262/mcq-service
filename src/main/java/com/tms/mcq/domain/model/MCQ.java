package com.tms.mcq.domain.model;

import java.util.List;

public class MCQ extends AggregatesRoot {
    private String mcqId;
    private String questionText;
    private List<Option> options;
}
