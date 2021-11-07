package com.tms.mcq.domain.events;

import lombok.Data;

@Data
public class NewQuestionTextAdded extends MCQUpdated {
    private String mcqId;
    private String questionText;

    private NewQuestionTextAdded(String mcqId, String questionText) {
        this.mcqId = mcqId;
        this.questionText = questionText;
    }

    public static NewQuestionTextAdded of(String mcqId, String questionText) {
        NewQuestionTextAdded questionTextAdded = new NewQuestionTextAdded(mcqId, questionText);
        return questionTextAdded;
    }
}
