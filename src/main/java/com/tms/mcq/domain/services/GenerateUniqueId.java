package com.tms.mcq.domain.services;

import com.tms.mcq.application.ports.out.SequenceService;
import com.tms.mcq.exception.MCQErrorCode;
import com.tms.mcq.exception.MCQIDGenerationException;
import com.tms.mcq.framework.annotation.DomainService;
import com.tms.mcq.framework.exception.ErrorCode;

@DomainService
public class GenerateUniqueId {

    SequenceService sequenceService;

    public GenerateUniqueId(SequenceService sequenceService){
        this.sequenceService = sequenceService;
    }

    /**
     * Generate unique sequenced mcq id using prefix ,
     * retry when connection to db is failed
     * @param subjectId
     * @return
     */
    public String generateMCQId(String subjectId) {
        try {
            String mcqId = "";
            Long seq = sequenceService.getNextSequence(subjectId);
            mcqId = subjectId + "-" + seq;
            return mcqId;
        } catch (Throwable throwable){
           throw MCQIDGenerationException.WithRecoveryDecision(MCQErrorCode.MCQ_10001,"Error while generating new mcqId",throwable);
        }
    }

}
