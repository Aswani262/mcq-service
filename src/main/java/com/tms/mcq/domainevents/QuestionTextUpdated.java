package com.tms.mcq.domainevents;

import lombok.Data;

@Data
public class QuestionTextUpdated extends MCQUpdated {
    private String mcqId;
    private String questionText;

    private QuestionTextUpdated(String mcqId, String questionText) {
        this.mcqId = mcqId;
        this.questionText = questionText;
    }

    public static QuestionTextUpdated of(String mcqId, String questionText) {
        QuestionTextUpdated evt = new QuestionTextUpdated(mcqId, questionText);
        return evt;
    }
}
