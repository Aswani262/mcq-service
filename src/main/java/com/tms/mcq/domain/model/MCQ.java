package com.tms.mcq.domain.model;

import com.tms.mcq.domain.events.MCQInitiated;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;

import java.util.List;
import java.util.Set;

@Getter
@NoArgsConstructor
@Setter(AccessLevel.PROTECTED)//No one able to access setter to change the property
public class MCQ extends AggregatesRoot  {
    private String mcqId;
    private String questionText;
    private List<Option> options;
    private List<Hints> hints;
    private Set<Integer> yearsInAsked;
    private Set<String> topicIds;
    private String subjectId;
    private Set<String> labelId;

    public MCQ(String mcqId,String questionText,List<Option> options,List<Hints> hints,Set<Integer> yearsInAsked,Set<String> topicIds,String subjectId,Set<String> labelId){
        this.mcqId= mcqId;
        this.questionText = questionText;
        this.options = options;
        this.hints = hints;
        this.yearsInAsked = yearsInAsked;
        this.topicIds = topicIds;
        this.subjectId = subjectId;
        this.labelId = labelId;
    }
}
