package com.tms.mcq.usecase.mcq;

import com.tms.framework.annotation.CommandHandler;
import com.tms.framework.annotation.UseCaseService;
import com.tms.framework.dto.ServiceResult;
import com.tms.framework.eventhandling.EventGateway;
import com.tms.framework.utils.ResponseKey;
import com.tms.mcq.domain.mcq.MCQ;
import com.tms.mcq.domain.mcq.Option;
import com.tms.mcq.exception.MCQErrorCode;
import com.tms.mcq.exception.MCQException;
import com.tms.mcq.persistence.MCQRepository;
import org.springframework.transaction.annotation.Transactional;

@UseCaseService
public class UpsertOptionService implements UpsertOptionUseCase {

    MCQRepository repository;
    EventGateway eventGateway;

    public UpsertOptionService(MCQRepository repository, EventGateway eventGateway) {
        this.repository = repository;
        this.eventGateway = eventGateway;
    }

    @Override
    @CommandHandler
    @Transactional
    public ServiceResult upsertOption(UpsertOptionsCmd cmd) {
        ServiceResult result = new ServiceResult();
        MCQ mcq = repository.findById(cmd.getMcqId()).get();
        if(mcq == null){
            throw new MCQException(MCQErrorCode.MCQ_10_001,"Invalid MCQId: "+cmd.getMcqId(),"");
        }
        for (UpsertOptionCmd upsertOptionCmd: cmd.getUpsertOptions()) {
             mcq.addOption(Option.of(upsertOptionCmd.getOptionText(),upsertOptionCmd.isAns()));
        }
        repository.store(mcq);
        result.addData(ResponseKey.message, "Option is added");
       // eventGateway.publish(OptionUpdated.of(mcq.getMcqId()));
        return result;
    }
}
