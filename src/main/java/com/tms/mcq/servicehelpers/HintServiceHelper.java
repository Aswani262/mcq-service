package com.tms.mcq.servicehelpers;

import com.tms.mcq.domain.mcq.MCQ;
import com.tms.mcq.exception.MCQErrorCode;
import com.tms.mcq.exception.MCQException;
import com.tms.mcq.persistence.MCQRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
  Only include method for internal using , not used by API
 */
@Component
public class HintServiceHelper {

    MCQRepository mcqRepository;

    public HintServiceHelper(MCQRepository mcqRepository) {
        this.mcqRepository = mcqRepository;
    }

    public MCQ requireMcq(String mcqId) {
        Optional<MCQ> mcqOptional = mcqRepository.findById(mcqId);
        if (mcqOptional.isEmpty()) {
            throw new MCQException(MCQErrorCode.MCQ_20_001, "Invalid MCQ Id :"+ mcqId,"");
        }
        return mcqOptional.get();
    }
}
