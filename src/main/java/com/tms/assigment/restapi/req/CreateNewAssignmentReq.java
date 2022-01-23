package com.tms.assigment.restapi.req;

import lombok.Data;

import java.util.List;

@Data
public class CreateNewAssignmentReq {
    private String subjectId;
    private List<String> topicIds;
    private String forExam;
    private int maxMarks;
    private int maxTime;
    private String assignmentType;
}
