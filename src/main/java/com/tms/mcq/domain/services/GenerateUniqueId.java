package com.tms.mcq.domain.services;

import com.tms.mcq.application.ports.out.SequenceService;
import com.tms.mcq.framework.annotation.DomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@DomainService
public class GenerateUniqueId {


    SequenceService sequenceService;



    public String generateMCQId(String orgCode, String subjectId) {
        String seq = sequenceService.getNextSequence("MCQ");
        String mcqId = orgCode+"-"+subjectId+"-"+seq;
        return mcqId;
    }
}
