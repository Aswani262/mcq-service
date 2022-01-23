package com.tms.batch.domain;

import com.tms.shared.AssignmentRef;
import com.tms.shared.SprintRef;
import com.tms.shared.TypeRef;
import com.tms.shared.UserRef;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

;

@Getter
@NoArgsConstructor
public class Batch {
    private String batchId;
    private String orgId;
    private String batchName;
    private String batchKey;
    private String description;
    private List<UserRef> studentIds;
    private List<UserRef> teacherIds;
    private UserRef batchAdmin;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private boolean isActive;
    private TypeRef targetExamId;//PRE-IIT,IIT,PMT,10,11,IAS
    private List<SprintRef>  sprintIds;
    private String syllabusId;
    private List<AssignmentRef> assignmentRefs;
    private List<ScheduleClasses> scheduleClasses;
}
