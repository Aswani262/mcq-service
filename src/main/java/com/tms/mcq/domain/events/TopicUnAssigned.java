package com.tms.mcq.domain.events;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TopicUnAssigned extends MCQUpdated {
    private String mcqId;
    private String topicCode;

    public static TopicUnAssigned of(String mcqId, String code) {
        TopicUnAssigned evt = new TopicUnAssigned(mcqId, code);
        return evt;
    }
}
