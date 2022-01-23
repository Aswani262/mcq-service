package com.tms.mcq.servicehelpers;

import com.tms.mcq.domain.mcq.MCQ;
import com.tms.mcq.persistence.MCQRepository;
import org.springframework.stereotype.Component;

@Component
public class MCQServiceHelper {

    MCQRepository mcqRepository;

    public MCQ findMCQById(String mcqId) {
       return mcqRepository.findById(mcqId).get();
    }
}
