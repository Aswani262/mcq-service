package com.tms.mcq.domain.model;

import com.tms.mcq.application.ports.in.commands.AddNewMCQCmd;
import com.tms.mcq.application.ports.in.commands.InitNewMCQCmd;

/**
 * A aggregate factor class to create aggregate
 */
public class MCQFactory {

    public static MCQ from(InitNewMCQCmd cmd,String mcqId) {
        MCQ mcq = new MCQ();
        mcq.setSubjectId(cmd.getSubjectId());
        mcq.setMcqId(mcqId);
        return mcq;
    }

    public static MCQ from(AddNewMCQCmd cmd) {
        MCQ mcq = new MCQ();
        mcq.setSubjectId(cmd.getSubjectId());
        mcq.setMcqId(cmd.getMcqId());
        return mcq;
    }
}
