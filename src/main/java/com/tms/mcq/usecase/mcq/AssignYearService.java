package com.tms.mcq.usecase.mcq;

import com.tms.framework.annotation.CommandHandler;
import com.tms.framework.annotation.UseCaseService;
import com.tms.framework.dto.ServiceResult;
import com.tms.mcq.domain.mcq.MCQ;
import com.tms.mcq.exception.MCQErrorCode;
import com.tms.mcq.exception.MCQException;
import com.tms.mcq.persistence.MCQRepository;
import org.springframework.transaction.annotation.Transactional;

@UseCaseService
public class AssignYearService implements AssignYearUseCase {

    MCQRepository repository;

    public AssignYearService(MCQRepository repository) {
        this.repository = repository;
    }

    @Override
    @CommandHandler
    @Transactional
    public ServiceResult assignYear(AssignYearCmd cmd) {
        ServiceResult result = new ServiceResult();
        MCQ mcq = repository.findById(cmd.getMcqId()).get();
        if(mcq == null){
            throw new MCQException(MCQErrorCode.MCQ_10_010,"Invalid MCQ Id:"+cmd.getMcqId(),"");
        }
        mcq.assignYear(cmd.getYear());
        repository.store(mcq);
        return result;
    }


}
