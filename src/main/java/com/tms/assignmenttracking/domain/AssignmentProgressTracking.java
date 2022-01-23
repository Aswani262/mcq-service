package com.tms.assignmenttracking.domain;

import java.time.LocalDateTime;
import java.util.List;

public class AssignmentProgressTracking {
    private String assignmentProgressTrackingId;
    private LocalDateTime startedTime;
    private LocalDateTime completedTime;
    private String assignmentId;
    private List<QuestionTracking> questionTrackings;
    private String status; //STARTED,PROGRESS,COMPLETED,EXPIRED, DEACTIVATED
}
