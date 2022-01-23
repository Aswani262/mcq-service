package com.tms.mcq.usecase.mcqapprovalprocess;

import com.tms.framework.dto.ServiceResult;
import com.tms.mcq.domain.mcqapprovalprocess.MCQApprovalProcess;
import com.tms.mcq.persistence.MCQApprovalProcessRepository;
import com.tms.mcq.servicehelpers.MCQApprovalProcessServieHelper;
import com.tms.shared.UserRef;

import java.util.List;

public class AssignMCQToApproverService implements AssignMCQToApproverUseCase {

    MCQApprovalProcessRepository mcqApprovalProcessRepository;

    MCQApprovalProcessServieHelper mcqApprovalProcessServieHelper;


    @Override
    public ServiceResult assignMCQToApprover(AssignMCQToApprover cmd) {
        ServiceResult result = new ServiceResult();
        List<UserRef> approvers = mcqApprovalProcessServieHelper.findAprroverIdByMCQId(cmd.getMcqId());
        MCQApprovalProcess mcqApprovalProcess = MCQApprovalProcess.from(cmd.getMcqId(),approvers);
        mcqApprovalProcessRepository.store(mcqApprovalProcess);
        return  result;
    }
}
