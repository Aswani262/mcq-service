package com.tms.mcq.application.ports.in.commands;

import com.tms.mcq.exception.MCQErrorCode;
import com.tms.mcq.exception.MCQException;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Getter
public class AddOrUpdateQuestionTextCmd extends MCQCommand {
    private String mcqId;
    private String questionText;

    protected AddOrUpdateQuestionTextCmd(String mcqId, String questionText) {
        this.mcqId = mcqId;
        this.questionText = questionText;
    }

    public static AddOrUpdateQuestionTextCmd from(String mcqId, String questionText) {
        if (StringUtils.isBlank(mcqId)) {
            throw new MCQException(MCQErrorCode.MCQ_10003, "Question Id is mandatory while adding or editing question", "mcqId is null or empty");
        }
        if (StringUtils.isBlank(questionText)) {
            throw new MCQException(MCQErrorCode.MCQ_10004, "A empty or blank question cannot be added or updated", "Question text is null or empty");
        }
        AddOrUpdateQuestionTextCmd cmd = new AddOrUpdateQuestionTextCmd(mcqId, questionText);
        return cmd;
    }
}
