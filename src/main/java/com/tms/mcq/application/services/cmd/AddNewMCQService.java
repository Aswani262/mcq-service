package com.tms.mcq.application.services.cmd;

import com.tms.mcq.adaptors.out.outboundservice.masterdata.model.MasterData;
import com.tms.mcq.adaptors.out.outboundservice.masterdata.query.GetMasterData;
import com.tms.mcq.application.ports.in.AddNewMCQUseCase;
import com.tms.mcq.application.ports.in.commands.AddNewMCQCmd;
import com.tms.mcq.application.ports.out.MCQRepository;
import com.tms.mcq.domain.model.MCQ;
import com.tms.mcq.domain.model.MCQFactory;
import com.tms.mcq.framework.annotation.UseCaseService;
import com.tms.mcq.framework.commandhandling.CommandGateway;
import com.tms.mcq.framework.annotation.CommandHandler;
import com.tms.mcq.framework.commandhandling.CommandResult;
import com.tms.mcq.framework.dto.ServiceResult;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@UseCaseService
public class AddNewMCQService implements AddNewMCQUseCase {

    MCQRepository mcqRepository;

    CommandGateway commandGateway;

    public AddNewMCQService(MCQRepository mcqRepository,CommandGateway commandGateway){
        this.mcqRepository = mcqRepository;
        this.commandGateway = commandGateway;
    }

    @CommandHandler
    public ServiceResult addNewMCQ(AddNewMCQCmd cmd){

        ServiceResult serviceResult = new ServiceResult();
        return serviceResult;
    }

    //Command Validator - its validate the data present in command like its exist or not unique or not
    //not contains the business validation , format validation and struture validation self contained in command
    @Override
    public List<String> validate(AddNewMCQCmd cmd)  {
        GetMasterData getMCQMasterData = new GetMasterData();
        CommandResult commandResult = null;

        commandResult = commandGateway.sendAndReceive(getMCQMasterData);

        MasterData masterData = (MasterData)commandResult.getData("masterData");
        boolean isTopicIdFound = masterData.getTopics().stream().anyMatch(topic -> topic.getName().equals(cmd.getTopicId()));
        boolean isSubjectFound = masterData.getSubject().stream().anyMatch(subject -> subject.getName().equals(cmd.getSubjectId()));

        List<String> error = new ArrayList<>(2);
        if(isSubjectFound && !isTopicIdFound) {
            error.add("No such topic found");
        } else if(!isSubjectFound && isSubjectFound){
            error.add("No such subject found");
        }
        return error;
    }
}
