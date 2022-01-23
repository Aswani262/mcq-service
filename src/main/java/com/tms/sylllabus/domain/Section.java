package com.tms.sylllabus.domain;

import com.tms.mcq.domain.AggregatesRoot;
import com.tms.shared.*;
import com.tms.sylllabus.domainservice.BussinessKeyService;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@NoArgsConstructor
public class Section extends AggregatesRoot {
    private String sectionId;
    private String heading;
    private String description;
    private String subjectTypeId;
    private Set<String> topicTypeId;
    private String label;
    private UserRef reporterId;
    private StatusRef statusId;
    private LabelRef labelId;
    private List<Link> links;
    private List<Link> attachments;
    private TypeRef targetExamId;
    private Set<String> childSectionId;
    private String parentSectionId;
    private String syllabusId;
    private Set<AssignmentRef> assignmentIds;
    private Map<String, CustomFieldAttribute> customFields;

    public static Section from(BussinessKeyService bussinessKeyService, String heading, String subjectTypeId, Set<String> topicTypeId, String syllabusId,String subjectCode) {
        Section section = new Section();
        String sectionKey = syllabusId+"-"+subjectCode;
        int seq = bussinessKeyService.getNewSequence(sectionKey);
        String sectionId = sectionKey+"-"+seq;
        section.sectionId = sectionId;
        section.heading = heading;
        section.subjectTypeId = subjectTypeId;
        section.topicTypeId = topicTypeId;
        section.syllabusId = syllabusId;
        return section;

    }
}
