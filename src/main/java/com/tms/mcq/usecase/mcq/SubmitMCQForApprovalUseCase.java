package com.tms.mcq.usecase.mcq;

import com.tms.framework.dto.ServiceResult;
import com.tms.mcq.usecase.mcq.commands.MCQCommand;
import lombok.Getter;

public interface SubmitMCQForApprovalUseCase {
    ServiceResult submitMCQForApproval(SubmitMCQ cmd);

    @Getter
    public static class SubmitMCQ extends MCQCommand {
        private String mcqId;

        public static SubmitMCQ from(String mcqId) {
            SubmitMCQ cmd = new SubmitMCQ();
            cmd.mcqId = mcqId;
            return cmd;
        }
    }
}
