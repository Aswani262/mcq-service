package com.tms.mcq.domain.mcqapprovalprocess;

import com.tms.mcq.domain.AggregatesRoot;
import com.tms.mcq.domain.mcq.ProcessStatus;
import com.tms.mcq.domain.shared.Comment;
import com.tms.mcq.domainevents.CommentAddedInMCQ;
import com.tms.mcq.domainevents.MCQAssignedToApprover;
import com.tms.mcq.domainevents.MCQProcessApproved;
import com.tms.shared.UserRef;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MCQApprovalProcess extends AggregatesRoot {
    private String processId;
    private String mcqId;
    private List<UserRef> assignedTo;
    private ProcessStatus status;
    private List<Comment> comments;
    private UserRef approvedBy;
    private LocalDateTime approvedOn;
    private LocalDateTime assignedOn;


    public static MCQApprovalProcess from(String mcqId, List<UserRef> approvers) {
        MCQApprovalProcess process = new MCQApprovalProcess();
        process.processId = "1234";
        process.mcqId = mcqId;
        process.assignedTo = approvers;
        process.status = ProcessStatus.IN_REVIEW;
        process.assignedOn = LocalDateTime.now();
        process.addEvent(MCQAssignedToApprover.of(process.mcqId,process.assignedTo));
        return process;
    }

    public boolean isApproved() {
        if(ProcessStatus.COMPLETED == status){
            return true;
        }
        return false;
    }

    public void addComment(Comment comment){
        this.comments.add(comment);
        addEvent(CommentAddedInMCQ.of(this.mcqId,comment));
    }

    public void approve(ProcessStatus status) {
        this.status = status;
        this.approvedOn = LocalDateTime.now();
        addEvent(MCQProcessApproved.of(mcqId,status));
    }

    public void changeStatus(ProcessStatus status) {
        this.status = status;

    }
}
