package com.tms.mcq.domainevents;

import com.tms.mcq.domain.shared.Comment;
import lombok.Data;

@Data
public class CommentAddedInMCQ extends MCQApprovalProcessEvent{
    private String mcqId;
    private Comment comment;

    public static CommentAddedInMCQ of(String mcqId, Comment comment) {
        CommentAddedInMCQ event = new CommentAddedInMCQ();
        event.comment = comment;
        event.mcqId = mcqId;
        return event;
    }
}
