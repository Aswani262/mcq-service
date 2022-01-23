package com.tms.mcq.persistence;

import com.tms.mcq.domain.mcqapprovalprocess.MCQApprovalProcess;

public interface MCQApprovalProcessRepository {
    void store(MCQApprovalProcess mcqApprovalProcess);

    MCQApprovalProcess findByMCQId(String mcqId);

    MCQApprovalProcess findByProcessId(String processId);
}
