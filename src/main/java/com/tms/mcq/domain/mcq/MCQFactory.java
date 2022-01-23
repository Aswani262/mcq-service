package com.tms.mcq.domain.mcq;

import com.tms.mcq.domainevents.MCQInitiated;
import com.tms.mcq.usecase.mcq.InitMCQUseCase;

/**
 * A aggregate factory class to create aggregate
 */
public class MCQFactory {

    /**
     * Build new MCQ instance with subject code and MCQId
     *
     * @param cmd
     * @param mcqId
     * @return
     */
    public static MCQ from(InitMCQUseCase.InitNewMCQCmd cmd, String mcqId) {
        MCQ mcq = new MCQ();
        mcq.setSubject(cmd.getSubjectId());
        mcq.setMcqId(mcqId);
        mcq.addEvent(new MCQInitiated(mcqId));
        return mcq;
    }

}
