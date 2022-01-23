package com.tms.mcq.usecase.mcqapprovalprocess;

import com.tms.framework.dto.ServiceResult;
import com.tms.mcq.usecase.mcq.commands.MCQApprovalCommand;
import lombok.Getter;

public interface AssignMCQToApproverUseCase {

    ServiceResult assignMCQToApprover(AssignMCQToApprover cmd);

    @Getter
    public class AssignMCQToApprover extends MCQApprovalCommand {
        private String mcqId;

        public static AssignMCQToApprover of(final String mcqId) {
            AssignMCQToApprover cmd = new AssignMCQToApprover();
            cmd.mcqId = mcqId;
            return cmd;
        }
    }
}
