package com.tms.student.domain;

import com.tms.shared.AssignmentRef;
import com.tms.shared.UserRef;

import java.time.LocalDateTime;

public class StudentAndAssignment {
    private UserRef studentId;
    private AssignmentRef assignmentId;
    private LocalDateTime assignedOn;
    private String status;//PENDING,STARTED,IN_PROGRESS,COMPLETED,EXPIRED

}
