package com.tms.mcq.usecase.mcq;

import com.tms.framework.annotation.CommandHandler;
import com.tms.framework.annotation.UseCaseService;
import com.tms.framework.dto.ServiceResult;
import com.tms.framework.eventhandling.EventGateway;
import com.tms.framework.utils.ResponseKey;
import com.tms.mcq.domain.mcq.MCQ;
import com.tms.mcq.exception.MCQErrorCode;
import com.tms.mcq.exception.MCQException;
import com.tms.mcq.persistence.MCQRepository;
import org.springframework.transaction.annotation.Transactional;

@UseCaseService
public class AssignLabelService implements AssignLabelUseCase {

    MCQRepository mcqRepository;
    EventGateway eventGateway;

    public AssignLabelService(MCQRepository mcqRepository) {

        this.mcqRepository = mcqRepository;
    }

    @Override
    @Transactional
    @CommandHandler
    public ServiceResult assignLabel(AssignLabel cmd) {
        ServiceResult result = new ServiceResult();
        MCQ mcq = mcqRepository.findById(cmd.getMcqId()).get();
        if(mcq == null){
            throw new MCQException(MCQErrorCode.MCQ_10_005,"Invalid MCQ Id:"+cmd.getMcqId(),"");
        }
        mcq.assignLabel(cmd.getLabel());
        mcqRepository.store(mcq);
        result.addData(ResponseKey.message, "Label assigned");
        return result;
    }


    @Transactional
    @CommandHandler
    public ServiceResult unAssignLabel(RemovedAssignedLabelUseCase.UnAssingLable cmd) {
        ServiceResult result = new ServiceResult();
        MCQ mcq = mcqRepository.findById(cmd.getMcqId()).get();
        if(mcq == null){
            throw new MCQException(MCQErrorCode.MCQ_10_005,"Invalid MCQ Id:"+cmd.getMcqId(),"");
        }
        mcq.unAssignLabel(cmd.getLabel());
        mcqRepository.store(mcq);
        result.addData(ResponseKey.message, "Label assigned");

        //Use aop to do this
        eventGateway.publish(mcq.getEvents());
        mcq.clear();
        return result;
    }
}
