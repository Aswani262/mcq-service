package com.tms.assignmenttracking.domain;

import java.time.LocalDateTime;

public class QuestionTracking {
    private String mcqId;
    private String status;//ATTEMPTED,SKIPPED
    private String optionSelected;
    private String seqNo;
    private LocalDateTime startedTime;
    private LocalDateTime completedTime;
    private int maxTime;
    private int maxMarks;
    private boolean isCorrectAnswered;
}
