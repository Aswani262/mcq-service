package com.tms.mcq.persistence;

import com.tms.mcq.domain.mcqapprovalprocess.MCQApprovalProcess;
import org.springframework.stereotype.Repository;

@Repository
public class MCQApprovalProcessRepositoryImpl implements MCQApprovalProcessRepository{
    @Override
    public void store(MCQApprovalProcess mcqApprovalProcess) {

    }

    @Override
    public MCQApprovalProcess findByMCQId(String mcqId) {
        return null;
    }

    @Override
    public MCQApprovalProcess findByProcessId(String processId) {
        return null;
    }
}
