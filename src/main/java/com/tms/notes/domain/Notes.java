package com.tms.notes.domain;

import com.tms.shared.LabelRef;
import com.tms.shared.SubjectRef;
import com.tms.shared.TopicRef;

import java.util.List;

public class Notes {
    private String noteId;
    private String docUrl;
    private String createdBy;
    private SubjectRef subjectId;
    private TopicRef  topicId;
    private List<LabelRef> labels;

}
