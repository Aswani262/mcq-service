package com.tms.mcq.domain.shared;

import com.tms.shared.UserRef;
import lombok.Value;

@Value
public class Comment {
    private UserRef commentBy;
    private String commentText;

    public static Comment of(UserRef userRef, String commentText) {
        Comment comment = new Comment(userRef,commentText);
        return comment;
    }
}
