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

import java.util.Optional;

@UseCaseService
public class UpsetHintService implements UpsertHintUseCase {

    MCQRepository mcqRepository;
    EventGateway eventGateway;


    public UpsetHintService(MCQRepository mcqRepository, EventGateway eventGateway) {
        this.mcqRepository = mcqRepository;
        this.eventGateway = eventGateway;
    }

    @CommandHandler
    @Transactional
    @Override
    public ServiceResult upsertHint(AddOrUpdateHintCmd cmd) {
        ServiceResult serviceResult = new ServiceResult();
        Optional<MCQ> mcqOptional = mcqRepository.findById(cmd.getMcqId());
        if(mcqOptional.isEmpty()){
             throw new MCQException(MCQErrorCode.MCQ_10_003,"Invalid MCQ Id:"+cmd.getMcqId(),"");
        }
        MCQ mcq = mcqOptional.get();
        mcq.addHint(cmd.getHint());
        mcqRepository.store(mcq);
        eventGateway.publish(mcq.getEvents());
        serviceResult.addData(ResponseKey.message,"Hint Updated successfully");
        return serviceResult;
    }
}
