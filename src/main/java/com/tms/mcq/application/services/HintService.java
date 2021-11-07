package com.tms.mcq.application.services;

import com.tms.mcq.application.ports.in.HintUseCase;
import com.tms.mcq.application.ports.in.commands.AddOrUpdateHintCmd;
import com.tms.mcq.application.ports.out.MCQRepository;
import com.tms.mcq.domain.model.MCQ;
import com.tms.mcq.exception.MCQErrorCode;
import com.tms.mcq.exception.MCQException;
import com.tms.mcq.framework.annotation.UseCaseService;
import com.tms.mcq.framework.dto.ServiceResult;
import com.tms.mcq.framework.eventhandling.EventGateway;

import java.util.Optional;

@UseCaseService
public class HintService implements HintUseCase {

    MCQRepository mcqRepository;
    EventGateway eventGateway;

    public HintService(MCQRepository mcqRepository, EventGateway eventGateway) {
        this.mcqRepository = mcqRepository;
        this.eventGateway = eventGateway;
    }

    @Override
    public ServiceResult upsertHint(AddOrUpdateHintCmd cmd) {
        ServiceResult serviceResult = new ServiceResult();
        Optional<MCQ> mcqOptional = mcqRepository.findById(cmd.getMcqId());
        if (mcqOptional.isEmpty()) {
            throw new MCQException(MCQErrorCode.MCQ_20001, "Question cannot be updated", "No Question exist for this id" + cmd.getMcqId());
        }
        MCQ mcq = mcqOptional.get();
        mcq.addOrUpdateHint(cmd.getHint());
        mcqRepository.store(mcq);
        eventGateway.publish(mcq.getEvents());
        return serviceResult;
    }
}
