package com.tms.mcq.usecase.mcq;

import com.tms.framework.annotation.CommandHandler;
import com.tms.framework.annotation.UseCaseService;
import com.tms.framework.dto.ServiceResult;
import com.tms.mcq.domain.mcq.MCQ;
import com.tms.mcq.exception.MCQErrorCode;
import com.tms.mcq.exception.MCQException;
import com.tms.mcq.persistence.MCQRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@UseCaseService
public class SubmitMCQForApprovalService implements SubmitMCQForApprovalUseCase {

    MCQRepository mcqRepository;

    public  SubmitMCQForApprovalService(MCQRepository mcqRepository){
        this.mcqRepository = mcqRepository;
    }

    @CommandHandler
    @Transactional
    @Override
    public ServiceResult submitMCQForApproval(SubmitMCQ cmd) {
        ServiceResult result = new ServiceResult();
        MCQ mcq = mcqRepository.findById(cmd.getMcqId()).get();
        List<String> errors = mcq.submitForApproval();
        if(!errors.isEmpty()){
           throw new MCQException(MCQErrorCode.MCQ_20_002,"Unable to submit Question",errors.toString());
        }
        return result;
    }
}
