package com.tms.mcq.application.ports.in;

import com.tms.mcq.application.ports.in.commands.AddOrUpdateQuestionTextCmd;
import com.tms.mcq.framework.dto.ServiceResult;

public interface QuestionTextUseCase {
    /**
     * Add new question text if not present
     * Update if present.
     * @param cmd
     * @return
     */
    public ServiceResult upsertQuestionText(AddOrUpdateQuestionTextCmd cmd);
}
