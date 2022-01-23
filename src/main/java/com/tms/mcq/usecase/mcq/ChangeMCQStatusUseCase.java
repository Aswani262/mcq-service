package com.tms.mcq.usecase.mcq;

import com.tms.framework.dto.ServiceResult;
import com.tms.mcq.usecase.mcq.commands.MCQCommand;
import lombok.Data;

public interface ChangeMCQStatusUseCase {
    ServiceResult changeMCQStatus(ChangeMCQStatus cmd);


    @Data
    public static class ChangeMCQStatus extends MCQCommand {
        private String mcqId;
        private String status;

        public static ChangeMCQStatus of(String mcqId, String inApproval) {
            ChangeMCQStatus cmd = new ChangeMCQStatus();
            cmd.mcqId = mcqId;
            cmd.status = inApproval;
            return cmd;
        }
    }
}
