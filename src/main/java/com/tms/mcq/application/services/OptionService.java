package com.tms.mcq.application.services;

import com.tms.mcq.application.ports.in.OptionUseCase;
import com.tms.mcq.application.ports.in.commands.UpsertOptionCmd;
import com.tms.mcq.application.ports.out.MCQRepository;
import com.tms.mcq.domain.model.MCQ;
import com.tms.mcq.domain.model.Option;
import com.tms.mcq.exception.MCQErrorCode;
import com.tms.mcq.exception.MCQException;
import com.tms.mcq.framework.annotation.CommandHandler;
import com.tms.mcq.framework.annotation.UseCaseService;
import com.tms.mcq.framework.dto.ServiceResult;
import com.tms.mcq.framework.utils.ResponseKey;
import org.springframework.transaction.annotation.Transactional;

@UseCaseService
public class OptionService implements OptionUseCase {

    MCQRepository repository;

    public OptionService(MCQRepository repository){
        this.repository = repository;
    }


    @Override
    @CommandHandler
    @Transactional
    public ServiceResult upsertOption(UpsertOptionCmd cmd) {
        ServiceResult result = new ServiceResult();
        MCQ mcq = repository.findById(cmd.getMcqId()).get();
        if(mcq == null){
            throw new MCQException(MCQErrorCode.MCQ_20003,"MCQ Id is need to update or create option","Provided MCQ ID not found in system");
        }
        mcq.addOrUpdate(Option.of(cmd.getSeqId(),cmd.getOptionText(),cmd.isAns()));
        repository.store(mcq);
        result.addData(ResponseKey.message,"Option is updated or added");
        return result;
    }
}
