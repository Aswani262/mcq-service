package com.tms.mcq.process;

import com.tms.framework.commandhandling.Dispatcher;
import com.tms.framework.dto.ServiceResult;
import com.tms.framework.eventhandling.EventGateway;
import com.tms.framework.eventhandling.EventHandler;
import com.tms.mcq.domain.mcq.Status;
import com.tms.mcq.domainevents.MCQAssignedToApprover;
import com.tms.mcq.domainevents.MCQProcessApproved;
import com.tms.mcq.domainevents.MCQSubmited;
import com.tms.mcq.usecase.mcq.ChangeMCQStatusUseCase;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;

@Component
public class MCQApprovalProcessManager {

//    Dispatcher dispatcher;
//
//    EventGateway eventGateway ;
//
//    public MCQApprovalProcessManager(Dispatcher dispatcher,EventGateway eventGateway){
//        this.dispatcher = dispatcher;
//        this.eventGateway = eventGateway;
//    }
//
//    @EventHandler
//    public void assignToApproverOnMCQSubmitted(MCQSubmited event) throws ExecutionException, InterruptedException {
//            dispatcher.sendAndReceive(AssignMCQToApprover.of(event.getMcqId()));
//    }
//
//    @EventHandler
//    public void changeMCQStatusOnAssingedToApprover(MCQAssignedToApprover event) throws ExecutionException, InterruptedException {
//           ServiceResult serviceResult = dispatcher.sendAndReceive(ChangeMCQStatusUseCase.ChangeMCQStatus.of(event.getMcqId(), Status.IN_APPROVAL.toString()));
//    }
//
//    @EventHandler
//    public void changeMCQStatusOnMCQProcessApproved(MCQProcessApproved event) throws ExecutionException, InterruptedException {
//            ServiceResult serviceResult = dispatcher.sendAndReceive(ChangeMCQStatusUseCase.ChangeMCQStatus.of(event.getMcqId(), Status.COMPLETED.toString()));
//    }
}
