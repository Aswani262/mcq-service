package com.tms.mcq.projections;

import com.tms.mcq.domain.mcq.DifficultyLevel;
import com.tms.mcq.domain.mcq.Option;
import com.tms.mcq.domain.mcq.ProcessStatus;
import com.tms.mcq.domain.mcq.Status;
import com.tms.mcq.domain.shared.Comment;
import com.tms.shared.UserRef;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class MCQQueryModel {
    private String mcqId;
    private String questionText;
    private Map<Integer, Option> options;
    private String hint;
    private Set<String> yearsInAsked;
    private Set<String> topics;
    private String subject;
    private Set<String> labels;
    private Status status;
    private Set<UserRef> watchers;
    private DifficultyLevel level;
    private List<UserRef> approvers;
    private ProcessStatus processStatus;
    private UserRef approvedBy;
    private Comment approvalProcessComment;

}
