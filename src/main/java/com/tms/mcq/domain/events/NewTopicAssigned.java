package com.tms.mcq.domain.events;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class NewTopicAssigned extends MCQUpdated {
    private String mcqId;
    private String topicCode;
    private String subjectCode;

    public static NewTopicAssigned of(String mcqId, String topicCode, String subjectCode) {
        NewTopicAssigned evt = new NewTopicAssigned(mcqId, topicCode, subjectCode);
        return evt;
    }
}
