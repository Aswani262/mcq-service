package com.tms.mcq.domain.events;

import com.tms.mcq.framework.eventhandling.DomainEvent;
import lombok.Data;

@Data
public class QuestionTextAdded extends MCQDomainEvent{
    private String mcqId;
    private String questionText;

    private QuestionTextAdded(String mcqId,String questionText){
        this.mcqId = mcqId;
        this.questionText = questionText;
    }

    public static QuestionTextAdded of(String mcqId, String questionText) {
        QuestionTextAdded questionTextAdded = new QuestionTextAdded(mcqId,questionText);
        return questionTextAdded;
    }
}
