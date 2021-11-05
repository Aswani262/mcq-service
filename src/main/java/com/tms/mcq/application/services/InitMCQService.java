package com.tms.mcq.application.services;

import com.tms.mcq.adaptors.out.outboundservice.masterdata.cmd.GetMasterData;
import com.tms.mcq.adaptors.out.outboundservice.masterdata.model.MasterData;
import com.tms.mcq.application.ports.in.InitNewQuestionCreationUseCase;
import com.tms.mcq.application.ports.in.commands.InitNewMCQCmd;
import com.tms.mcq.application.ports.out.MCQRepository;
import com.tms.mcq.domain.model.MCQ;
import com.tms.mcq.domain.model.MCQFactory;
import com.tms.mcq.domain.services.GenerateUniqueId;
import com.tms.mcq.exception.MCQErrorCode;
import com.tms.mcq.exception.MCQException;
import com.tms.mcq.framework.annotation.UseCaseService;
import com.tms.mcq.framework.annotation.CommandHandler;
import com.tms.mcq.framework.commandhandling.CommandGateway;
import com.tms.mcq.framework.commandhandling.CommandResult;
import com.tms.mcq.framework.dto.ServiceResult;
import com.tms.mcq.framework.eventhandling.EventGateway;
import com.tms.mcq.framework.utils.MessageCode;
import com.tms.mcq.framework.utils.ResponseKey;
import com.tms.mcq.framework.utils.ServiceUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@UseCaseService //or application service
@Log4j2
public class InitMCQService implements InitNewQuestionCreationUseCase {

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
    CommandGateway commandGateway;

    public InitMCQService(MCQRepository mcqRepository,GenerateUniqueId generateUniqueId,EventGateway eventGateway,CommandGateway commandGateway){
        this.mcqRepository = mcqRepository;
        this.generateUniqueId = generateUniqueId;
        this.eventGateway = eventGateway;
        this.commandGateway = commandGateway;
    }
    // Write an aop to log all the exception and convert into MCQ Exception
    /**
     * It will assign a insisiate new MCQ creation in system
     * It will throw runtime MCQInitException
     * @param cmd
     * @return
     */
    @Override
    @Transactional
    @CommandHandler
    public ServiceResult init(InitNewMCQCmd cmd) {
        ServiceResult result = new ServiceResult();
        try {
            validate(cmd);
            String mcqId = generateUniqueId.generateMCQId(cmd.getSubjectId());
            MCQ mcq = MCQFactory.from(cmd, mcqId);
            mcqRepository.store(mcq);
            result.addData(ResponseKey.mcqId, mcqId);
            result.addData(ResponseKey.message, MessageCode.MCQ_10003);
            eventGateway.publish(mcq.getEvents());
        } catch (Throwable throwable){// TODO: Use aop to handle exception - at time of handling log request and response
            ServiceUtils.handleException(throwable);
        }
        return result;
    }

    private void validate(InitNewMCQCmd cmd) {
        GetMasterData getMasterData = new GetMasterData();
        getMasterData.setSubjectCode(cmd.getSubjectId());

        CommandResult commandResult = commandGateway.sendAndReceive(getMasterData);
        MasterData masterData = (MasterData)commandResult.getData().get("masterData");

        if(!masterData.getSubject().contains(cmd.getSubjectId())){
           throw new MCQException(MCQErrorCode.MCQ_10002,"Invalid subject code","Subject code not exist in system");
        }
    }

}
