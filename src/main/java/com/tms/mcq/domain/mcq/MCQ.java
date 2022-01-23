package com.tms.mcq.domain.mcq;

import com.tms.mcq.domain.AggregatesRoot;
import com.tms.mcq.domainevents.*;
import com.tms.shared.UserRef;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

@Getter
@NoArgsConstructor
@Setter(AccessLevel.PROTECTED)
public class MCQ extends AggregatesRoot {
    private String mcqId;
    private String questionText;
    private Map<Integer, Option> options;
    private String hint;
    private Set<String> yearsInAsked;//20011,2012
    private Set<String> topics;// Integration
    private String subject; // Math
    private Set<String> labels; //
    private Status status; // Stared , Submitted , Approved
    private Set<UserRef> watchers;
    private DifficultyLevel level; // Easy , Hard , Avergae
    private String targetExam; // SSC , BANK , IIT , 10 , 11
    private int marks;
    private int maxTimeToComplete;

    public void addHint(final String hint) {
        if(this.hint == null){
            addEvent(NewHintAdded.of(this.mcqId,hint));
        } else {
            addEvent(HintUpdated.of(this.mcqId,hint));
        }
        this.hint = hint;
    }

    public void addQuestionText(final String questionText) {
        if(this.questionText == null){
            addEvent(NewQuestionTextAdded.of(this.mcqId,questionText));
        } else {
            addEvent(QuestionTextUpdated.of(this.mcqId,questionText));
        }
        this.questionText = questionText;
    }

    public void addOption(final Option option) {
        this.options = new HashMap<>();
        this.options.put(this.options.size()+1,option);
    }

    public void assignLabel(final String label) {
        this.labels.add(label);
        addEvent(NewLabelAssigned.of(this.mcqId,label));
    }

    public void unAssignLabel(String label) {
        this.labels.remove(label);
        addEvent(LabelUnAssigned.of(this.mcqId,label));
    }

    public void assignYear(final String year) {
        this.yearsInAsked.add(year);
        addEvent(NewYearAssigned.of(this.mcqId,year));
    }

    public void unaAssignYear(final String year) {
        this.yearsInAsked.remove(year);
        addEvent(YearUnAssigned.of(this.mcqId,year));
    }

    public List<String> submitForApproval() {
        List<String> error = new ArrayList<>();
        if(StringUtils.isBlank(this.questionText)){
                 error.add("Question is not provided");
        }
        if(StringUtils.isBlank(this.subject)){
            error.add("Assign at least one subject");
        }
        if(ObjectUtils.isEmpty(this.topics)){
            error.add("Assign at least one topic");
        }
        this.status = Status.SUBMITTED_FOR_APPROVAL;
        addEvent(MCQSubmited.of(mcqId,status));
        return error;
    }

    public void changeStatus(Status status) {
        if(Status.COMPLETED == status){
            addEvent(MCQApproved.of(mcqId));
        }
        this.status = status;
    }
}



