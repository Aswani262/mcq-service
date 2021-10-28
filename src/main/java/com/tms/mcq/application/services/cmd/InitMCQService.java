package com.tms.mcq.application.services.cmd;

import com.tms.mcq.application.ports.in.AddNewMCQUseCase;
import com.tms.mcq.application.ports.in.InitNewQuestionCreationUseCase;
import com.tms.mcq.application.ports.in.commands.InitNewMCQCmd;
import com.tms.mcq.application.ports.out.SequenceService;
import com.tms.mcq.application.ports.out.MCQRepository;
import com.tms.mcq.domain.model.MCQ;
import com.tms.mcq.domain.model.MCQFactory;
import com.tms.mcq.domain.services.GenerateUniqueId;
import com.tms.mcq.framework.annotation.UseCaseService;
import com.tms.mcq.framework.annotation.CommandHandler;
import com.tms.mcq.framework.dto.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@UseCaseService //or application service
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

    public InitMCQService(MCQRepository mcqRepository,GenerateUniqueId generateUniqueId){
        this.mcqRepository = mcqRepository;
        this.generateUniqueId = generateUniqueId;
    }

    /**
     * It will assign a new MCQId to question and status = "Inisiated";
     * @param cmd
     * @return
     */
    @Override
    @Transactional
    public ServiceResult init(InitNewMCQCmd cmd) {
        ServiceResult result = new ServiceResult();
        try {
            String mcqId = generateUniqueId.generateMCQId(cmd.getOrgCode(), cmd.getSubjectId());
            MCQ mcq = MCQFactory.from(cmd, mcqId);
            mcqRepository.store(mcq);
            result.addData("mcqId", mcqId);
            result.addData("message", "MCQ Question created");
        } catch (Throwable th){
            result.addError("1223","unable to create mcq");
        }
        return result;
    }
}
