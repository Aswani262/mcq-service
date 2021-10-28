package com.tms.mcq.domain.model;

import com.tms.mcq.domain.events.MCQInisited;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@NoArgsConstructor
@Setter(AccessLevel.PACKAGE)
public class MCQ extends AggregatesRoot  {
    private String mcqId;
    private String questionText;
    private List<Option> options;
    private List<Hints> hints;
    private Set<Integer> yearsInAsked;
    private Set<String> topicIds;
    private String subjectId;
    private Set<String> labelId;

    //Also used by spring data jpa , so dont put any kind of validation logic here
    public MCQ(String mcqId,String questionText,List<Option> options,List<Hints> hints,Set<Integer> yearsInAsked,Set<String> topicIds,String subjectId,Set<String> labelId){
        this.mcqId= mcqId;
        this.questionText = questionText;
        this.options = options;
        this.hints = hints;
        this.yearsInAsked = yearsInAsked;
        this.topicIds = topicIds;
        this.subjectId = subjectId;
        this.labelId = labelId;
        addEvent(new MCQInisited());
    }

}
