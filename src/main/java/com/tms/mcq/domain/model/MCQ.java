package com.tms.mcq.domain.model;

import com.tms.mcq.application.ports.in.commands.AddOrUpdateHintCmd;
import com.tms.mcq.domain.events.HintUpdated;
import com.tms.mcq.domain.events.MCQUpdated;
import com.tms.mcq.domain.events.NewHintAdded;
import com.tms.mcq.domain.events.QuestionTextAdded;
import lombok.*;

import java.util.*;

@Getter
@NoArgsConstructor
@Setter(AccessLevel.PROTECTED)//No one able to access setter to change the property
public class MCQ extends AggregatesRoot  {
    private String mcqId;
    private String questionText;
    private Set<Option> options;
    private Set<Hint> hints;
    private Set<String> yearsInAsked;
    private Set<TopicRef> topicIds; // Available globally
    private SubjectRef subjectId; // Available globally
    private Set<LabelRef> labelId; // label will be available globally

    public MCQ(String mcqId, String questionText, Set<Option> options, Set<Hint> hints, Set<String> yearsInAsked, Set<TopicRef> topicIds, SubjectRef subjectId, Set<LabelRef> labelId){
        this.mcqId= mcqId;
        this.questionText = questionText;
        this.options = options;
        this.hints = hints;
        this.yearsInAsked = yearsInAsked;
        this.topicIds = topicIds;
        this.subjectId = subjectId;
        this.labelId = labelId;
    }


    public void updateHint(final Hint hint) {
        //no need of structural validation
        //Can put assert statement , which can be off at production
        this.hints.removeIf(hintToRemove -> hintToRemove.equals(hint));
        this.hints.add(hint);
        addEvent(HintUpdated.of(mcqId,hint.getSeqId(),hint.getHintText()));
    }

    public void addHint(final Hint hint) {
        if(this.hints == null || this.hints.isEmpty()){
            this.hints = new HashSet<>();
            this.hints.add(hint);
            addEvent(NewHintAdded.of(mcqId,hint.getSeqId(),hint.getHintText()));
        }
    }

    public boolean isHintExist(Hint hint) {
        if(this.hints == null || this.hints.isEmpty()){
            return false;
        }
        if(this.hints.contains(hint)){
            return true;
        } else {
            return false;
        }
    }

    public void addOrUpdateQuestionText(final String questionText) {
        this.questionText = questionText;
    }

    public void addOrUpdate(final Option option) {
        if(this.options == null || this.options.isEmpty()){
            this.options = new HashSet<>();
        } else {
          this.options.removeIf(option1 -> option.equals(option1));
        }
        this.options.add(option);
        addEvent(MCQUpdated.of(mcqId));
    }

    public void addOrUpdateYear(String year) {
        if(this.yearsInAsked == null || this.yearsInAsked.isEmpty()){
            this.yearsInAsked = new HashSet<>();
        }
        this.yearsInAsked.add(year);
    }
}
