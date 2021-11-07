package com.tms.mcq.domain.model;

import com.tms.mcq.domain.events.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@NoArgsConstructor
@Setter(AccessLevel.PROTECTED)//No one able to access setter to change the property , to
// Get a new Object using the Aggregate factory class , MCQFactory
public class MCQ extends AggregatesRoot {
    private String mcqId;
    private String questionText;
    private Set<Option> options;
    private String hint;
    private Set<String> yearsInAsked;
    private Set<TopicRef> topicIds; // Available globally
    private SubjectRef subjectId; // Available globally
    private Set<LabelRef> labelIds; // label will be available globally
    private Status status;

    //Just use by persistence framework for instantiation, don't put any kind of validation logic
    public MCQ(String mcqId, String questionText, Set<Option> options, String hint, Set<String> yearsInAsked, Set<TopicRef> topicIds, SubjectRef subjectId, Set<LabelRef> labelIds, Status status) {
        this.mcqId = mcqId;
        this.questionText = questionText;
        this.options = options;
        this.hint = hint;
        this.yearsInAsked = yearsInAsked;
        this.topicIds = topicIds;
        this.subjectId = subjectId;
        this.labelIds = labelIds;
        this.status = status;
    }

    /**
     * Add hint to MCQ. Always replace new with old one.
     * Its works for  add , update and removal of hint in MCQ.
     * In case of empty of null case - considered as removing of
     * hint from MCQ
     *
     * @param hint
     */
    public void addOrUpdateHint(final String hint) {
        //Hint considered as value object so always replace with new hint
        if (this.hint == null || this.hint.isEmpty()) {
            addEvent(NewHintAdded.of(this.mcqId, this.hint));
        } else {
            addEvent(HintUpdated.of(this.mcqId, this.hint));
        }
        this.hint = hint;
    }

    /**
     * Add question to MCQ. Always replace new with old one.
     * Its works for  add , update and removal of question in MCQ.
     * In case of empty of null case - considered as removing of
     * question from MCQ
     *
     * @param questionText
     */
    public void addOrUpdateQuestionText(final String questionText) {
        if (this.questionText == null || this.questionText.isEmpty()) {
            addEvent(NewQuestionTextAdded.of(this.mcqId, this.questionText));
        } else {
            addEvent(QuestionTextUpdated.of(this.mcqId, this.questionText));
        }
        this.questionText = questionText;
    }

    public void addOption(final Option option) {
        //Option is always treat as value object , always replace
        if (this.options == null || this.options.isEmpty()) {
            this.options = new HashSet<>();
        }
        addEvent(NewOptionAdded.of(mcqId, option.getSeqId(), option.getOptionText(), option.isAns()));
        this.options.add(option);
    }

    public boolean isOptionExist(final Option option) {
        if (this.options == null || this.options.isEmpty()) {
            return false;
        }
        return this.options.contains(option);
    }

    public boolean updateOption(final Option option) {
        if (this.options.remove(option)) {
            //Replace option with new one in case of update
            this.options.add(option);
            addEvent(OptionUpdated.of(mcqId, option.getSeqId(), option.getOptionText(), option.isAns()));
            return true;
        }
        return false;
    }

    public boolean removeOption(final Option option) {
        if (this.options.remove(option)) {
            addEvent(OptionUpdated.of(mcqId, option.getSeqId(), option.getOptionText(), option.isAns()));
            return true;
        }
        return false;
    }

    public boolean assignYearInAsked(final String year) {
        if (this.yearsInAsked == null || this.yearsInAsked.isEmpty()) {
            this.yearsInAsked = new HashSet<>();
        }
        if (this.yearsInAsked.add(year)) {
            addEvent(NewYearAssigned.of(mcqId, year));
            return true;
        }
        return false;
    }

    public boolean unAssignYearInAsked(final String year) {
        if (this.yearsInAsked == null || this.yearsInAsked.isEmpty()) {
            this.yearsInAsked = new HashSet<>();
        }
        if (yearsInAsked.remove(year)) {
            addEvent(YearUnAssigned.of(mcqId, year));
            return true;
        }
        return false;
    }

    public boolean assignTopic(TopicRef topicId) {
        if (this.topicIds == null || this.topicIds.isEmpty()) {
            this.topicIds = new HashSet<>();
        }
        if (this.topicIds.add(topicId)) {
            addEvent(NewTopicAssigned.of(mcqId, topicId.getCode(), subjectId.getCode()));
            return true;
        }
        return false;
    }

    public boolean unAssignTopic(TopicRef topicId) {
        if (this.topicIds == null || this.topicIds.isEmpty()) {
            return false;
        }
        if (topicIds.remove(topicId)) {
            addEvent(TopicUnAssigned.of(this.mcqId, topicId.getCode()));
            return true;
        }
        return false;
    }

    public boolean assignLabel(LabelRef labelId) {
        if (this.labelIds == null || this.labelIds.isEmpty()) {
            this.labelIds = new HashSet<>();
        }
        if (this.labelIds.add(labelId)) {
            addEvent(NewLabelAssigned.of(mcqId, labelId.getCode()));
            return true;
        }
        return false;
    }

    public boolean unAssignLabel(LabelRef labelId) {
        if (this.labelIds == null || this.labelIds.isEmpty()) {
            return false;
        }
        if (labelIds.remove(labelId)) {
            addEvent(LabelUnAssigned.of(mcqId, labelId.getCode()));
            return true;
        }
        return false;
    }
}
