package com.tms.mcq.usecase.mcq;

import com.tms.framework.dto.ServiceResult;
import com.tms.mcq.domain.mcq.MCQ;
import com.tms.mcq.exception.MCQErrorCode;
import com.tms.mcq.exception.MCQException;
import com.tms.mcq.persistence.MCQRepository;

public class RemoveAssignedYearService implements RemoveAssignedYearUseCase {

    MCQRepository repository;

    public RemoveAssignedYearService(MCQRepository repository) {
        this.repository = repository;
    }

    @Override
    public ServiceResult UnAssignYear(UnAssignYearCmd cmd) {
        ServiceResult result = new ServiceResult();
        MCQ mcq = repository.findById(cmd.getMcqId()).get();
        if(mcq == null){
            throw new MCQException(MCQErrorCode.MCQ_10_010,"Invalid MCQ Id:"+cmd.getMcqId(),"");
        }
        mcq.unaAssignYear(cmd.getYear());
        repository.store(mcq);
        return result;
    }
}
