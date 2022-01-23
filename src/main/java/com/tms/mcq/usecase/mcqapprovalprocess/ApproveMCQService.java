package com.tms.mcq.usecase.mcqapprovalprocess;

import com.tms.framework.annotation.UseCaseService;
import com.tms.framework.dto.ServiceResult;
import com.tms.mcq.domain.mcq.ProcessStatus;
import com.tms.mcq.domain.mcqapprovalprocess.MCQApprovalProcess;
import com.tms.mcq.exception.MCQErrorCode;
import com.tms.mcq.exception.MCQException;
import com.tms.mcq.persistence.MCQApprovalProcessRepository;


@UseCaseService
public class ApproveMCQService implements ApproveMCQUseCase {

    MCQApprovalProcessRepository mcqApprovalProcessRepository;

    public  ApproveMCQService(MCQApprovalProcessRepository mcqApprovalProcessRepository){
        this.mcqApprovalProcessRepository = mcqApprovalProcessRepository;
    }


    @Override
    public ServiceResult approveMCQ(ApproveMCQ cmd) {
        ServiceResult result = new ServiceResult();
        MCQApprovalProcess process = mcqApprovalProcessRepository.findByProcessId(cmd.getProcessId());
        if(!process.isApproved()){
            process.approve(ProcessStatus.COMPLETED);
        } else {
            throw new MCQException(MCQErrorCode.MCQ_10_017,"MCQ Already approved","");
        }
        //Publish event - MCQProcessApproved
        return result;
    }
}
