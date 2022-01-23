package com.tms.sylllabus.domain;

import com.tms.mcq.domain.AggregatesRoot;
import com.tms.shared.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

//Once the batch is created and target exam is assigned
// Batch board is created with subject categories and showing all the teacher
// System automatically create a task for each topic , BATCH-NAME-SUBJECT-NAME-01 (Subject and Sequence)
// Task is in pending status in Sallabus Goal Section
// Branch admin will create a Spring with specified no of days
// and pick task from Sallabus and put into backlog
// same for the assigment section ,
public class Syllabus extends AggregatesRoot {
    private String syllabusId;
    private String syllabusKey;
    private SyllabusYear syllabusYear;
    private String heading;
    private String description;
    private UserRef reporterId;
    private StatusRef statusId;
    private LabelRef labelId;
    private List<Link> links;
    private List<Link> attachments;
    private TypeRef targetExamTypeId;
    private String subjectTypeId;
    private Set<String> topicTypeIds;
    private Set<AssignmentRef> mockTests;
    private Set<String> sectionIds;
    private Map<String, CustomFieldAttribute> customFields;

    public static Syllabus from(String targetExamTypeId, String targetExamCode,String heading) {
        Syllabus syllabus = new Syllabus();
        syllabus.syllabusId = targetExamCode +"-"+ LocalDateTime.now().getDayOfYear();
        syllabus.heading = heading;
        syllabus.targetExamTypeId = new TypeRef(targetExamTypeId);
        return syllabus;
    }

    public boolean linkChildSection(String sectionId) {
        return this.sectionIds.add(sectionId);
    }
}
