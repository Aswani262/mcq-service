package com.tms.mcq.servicehelpers;

import com.tms.mcq.domain.mcqapporover.MCQApprover;
import com.tms.shared.UserRef;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MCQApprovalProcessServieHelper {

    MCQApproverServiceHelpers mcqApproverServiceHelpers;

    public List<UserRef> findAprroverIdByMCQId(String mcqId) {
        List<MCQApprover> mcqApprovers = mcqApproverServiceHelpers.findAprroverByMCQId(mcqId);
        List<UserRef> approverUsers = new ArrayList<>();
        mcqApprovers.stream().forEach(mcqApprover -> approverUsers.add(mcqApprover.getUserId()));
        return approverUsers;
    }
}
