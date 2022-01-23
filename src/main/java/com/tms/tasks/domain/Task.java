package com.tms.tasks.domain;

import com.tms.mcq.domain.AggregatesRoot;
import com.tms.mcq.domain.shared.Comment;
import com.tms.shared.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

@Getter
@NoArgsConstructor
public class Task extends AggregatesRoot {
    private String taskId; //BatchKey+Sequence
    private String batchId;
    private String heading;
    private String description;
    private UserRef reporterId;
    private UserRef assignedId;
    private StatusRef statusId;
    private LabelRef labelId;
    private List<Link> links;
    private TypeRef taskTypeId; // AssignmentTask,SyllabusTask,RevisionTask,MockTestTask,GoalTask
    private TimeEstimated timeEstimated;
    private TimeLoged timeLoged;
    private List<Comment> comments;
    private Set<TaskRef> childTaskIds;
    private LinkedHashMap<TaskRef,String> linksTaskIds;
    private LocalDateTime startDate;
    private LocalDateTime dueDate;
    private String sectionId;
    private String syllabusId;
    private String subjectTypeId;
    private List<String> topicTypeIds;
    private String targetExamTypeId;
}
