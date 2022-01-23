package com.tms.mcq.usecase.mcqapprovalprocess;

import com.tms.framework.dto.ServiceResult;
import com.tms.mcq.usecase.mcq.commands.MCQCommand;
import lombok.Data;

public interface ApproveMCQUseCase {

    ServiceResult approveMCQ(ApproveMCQ cmd);

    @Data
    public class ApproveMCQ extends MCQCommand {
        private String processId;
    }
}
