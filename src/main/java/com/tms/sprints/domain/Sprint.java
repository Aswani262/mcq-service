package com.tms.sprints.domain;

import com.tms.shared.TaskRef;

import java.time.LocalDateTime;
import java.util.List;

public class Sprint {
    private String sprintId;
    private int noOfDays;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private List<TaskRef> tasksId;

}
