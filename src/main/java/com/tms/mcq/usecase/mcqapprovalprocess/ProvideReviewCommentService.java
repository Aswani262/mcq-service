package com.tms.mcq.usecase.mcqapprovalprocess;

import com.tms.framework.annotation.CommandHandler;
import com.tms.framework.annotation.UseCaseService;
import com.tms.framework.dto.ServiceResult;
import com.tms.mcq.domain.mcqapprovalprocess.MCQApprovalProcess;
import com.tms.mcq.domain.shared.Comment;
import com.tms.mcq.persistence.MCQApprovalProcessRepository;
import com.tms.shared.UserRef;
import org.springframework.transaction.annotation.Transactional;

@UseCaseService
public class ProvideReviewCommentService implements ProvideReviewCommentUseCase {

    MCQApprovalProcessRepository processRepository;

    @CommandHandler
    @Transactional
    @Override
    public ServiceResult addReviewComment(AddReviewComment cmd) {
        ServiceResult result = new ServiceResult();
        MCQApprovalProcess mcqApprovalProcess = processRepository.findByMCQId(cmd.getMcqId());
       // mcqApprovalProcess.addComment(Comment.of(new UserRef(cmd.getCommentText()),cmd.getCommentText()));
        return result;
    }
}
