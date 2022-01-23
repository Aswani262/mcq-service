package com.tms.mcq.usecase.mcq;

import com.tms.framework.annotation.CommandHandler;
import com.tms.framework.annotation.UseCaseService;
import com.tms.framework.commandhandling.Dispatcher;
import com.tms.framework.dto.ServiceResult;
import com.tms.framework.eventhandling.EventGateway;
import com.tms.framework.utils.ResponseKey;
import com.tms.mcq.domain.mcq.GenerateUniqueId;
import com.tms.mcq.domain.mcq.MCQ;
import com.tms.mcq.domain.mcq.MCQFactory;
import com.tms.mcq.exception.MCQErrorCode;
import com.tms.mcq.exception.MCQException;
import com.tms.mcq.persistence.MCQRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@UseCaseService //or application service
@Log4j2
public class InitMCQService implements InitMCQUseCase {

    //Some thought on master data -
    //Since operation on master data is more read than write
    //No one adding Subject and topic daily but reading happen more
    //So there must be some sort of distribute-caching (other service will read from distributed cache rather than calling service or used by client directly to get data )of master data of these service
    // We have to apply cache logic in such way , whenever master data is updated like adding new subject or topic
    // that will publish to cache immediately. So it will be available.
    // Some thought on query - result of query should always provide using in-memory-caching or in memory database
    // Some thought on in-memory-database - In memory database will hold the data according to snapshot concept
    // Snapshot is something like - Will hold only 3 MB of data for each Aggregate or First 300 Records.

    MCQRepository mcqRepository;
    GenerateUniqueId generateUniqueId;
    EventGateway eventGateway;
    Dispatcher commandGateway;

    public InitMCQService(MCQRepository mcqRepository, GenerateUniqueId generateUniqueId, EventGateway eventGateway, Dispatcher commandGateway) {
        this.mcqRepository = mcqRepository;
        this.generateUniqueId = generateUniqueId;
        this.eventGateway = eventGateway;
        this.commandGateway = commandGateway;

    }
    // Write an aop to log all the exception and convert into MCQ Exception

    /**
     * It will assign an init new MCQ creation in system
     * It will throw runtime MCQInitException
     *
     * @param cmd
     * @return
     */
    @Override
    @Transactional
    @CommandHandler
    public ServiceResult init(InitNewMCQCmd cmd) {
        ServiceResult result = new ServiceResult();
        String mcqId = generateUniqueId.generateMCQId(cmd.getSubjectId());
        MCQ mcq = MCQFactory.from(cmd, mcqId);
        mcqRepository.store(mcq);
        result.addData(ResponseKey.mcqId, mcqId);
        eventGateway.publish(mcq.getEvents());
        return result;
    }

    @Override
    public ServiceResult submitMCQ(SubmitMCQForApprovalUseCase.SubmitMCQ cmd) {
        ServiceResult result = new ServiceResult();
        MCQ mcq = mcqRepository.findById(cmd.getMcqId()).get();
        List<String> submitResult = mcq.submitForApproval();
        if(!submitResult.isEmpty()){
            throw new MCQException(MCQErrorCode.MCQ_20_002,"Unable to submit",submitResult.toString());
        }
        result.markSuccess();
        return result;
    }

}
