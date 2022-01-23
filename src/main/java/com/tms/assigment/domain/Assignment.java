package com.tms.assigment.domain;


import java.util.List;

public class Assignment {
    private String assignmentId;
    private String assignmentType;//TOPIC_WISE,SUBJECT_WISE,MOCK_TEST
    private String targetExamId;
    private String subjectId;
    private String topicId;
    private List<AssignmentQuestion> assignmentQuestion;
    private int maxTime;
    private int totalMarks;
    private boolean isActive;
}
