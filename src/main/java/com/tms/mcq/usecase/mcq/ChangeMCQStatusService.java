package com.tms.mcq.usecase.mcq;

import com.tms.framework.dto.ServiceResult;
import com.tms.mcq.domain.mcq.MCQ;
import com.tms.mcq.domain.mcq.Status;
import com.tms.mcq.exception.MCQErrorCode;
import com.tms.mcq.exception.MCQException;
import com.tms.mcq.persistence.MCQRepository;

public class ChangeMCQStatusService implements ChangeMCQStatusUseCase {

    MCQRepository mcqRepository;


    public ChangeMCQStatusService(MCQRepository mcqRepository){
        this.mcqRepository = mcqRepository;
    }

    @Override
    public ServiceResult changeMCQStatus(ChangeMCQStatus cmd) {
        ServiceResult result = new ServiceResult();

        MCQ mcq  = mcqRepository.findById(cmd.getMcqId()).get();
        if(mcq == null){
            throw  new MCQException(MCQErrorCode.MCQ_10_016,"Invalid MCQ Id","");
        }
        mcq.changeStatus(Status.valueOf(cmd.getStatus()));


        return null;
    }
}
