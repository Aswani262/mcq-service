package com.tms.mcq.usecase.mcqapprovalprocess;

import com.tms.framework.dto.ServiceResult;
import com.tms.mcq.usecase.mcq.commands.MCQCommand;
import lombok.Getter;

public interface ProvideReviewCommentUseCase {

    ServiceResult addReviewComment(AddReviewComment cmd);

    @Getter
    public class AddReviewComment extends MCQCommand {
        private String mcqId;
        private String commentText;
        private String commentBy;

    }

}
