package com.tms.mcq.domain.model;

import com.tms.mcq.application.ports.in.commands.InitNewMCQCmd;
import com.tms.mcq.domain.events.MCQInitiated;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
    public static MCQ from(InitNewMCQCmd cmd, String mcqId) {
        MCQ mcq = new MCQ();
        mcq.setSubjectId(new SubjectRef(cmd.getSubjectId()));
        mcq.setMcqId(mcqId);
        mcq.addEvent(new MCQInitiated(mcqId));
        return mcq;
    }

}
