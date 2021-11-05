package com.tms.mcq.domain.events;

import com.tms.mcq.framework.eventhandling.DomainEvent;
import lombok.Data;
import lombok.Getter;

@Getter
public class NewHintAdded extends MCQDomainEvent{
    private String mcqId;
    private int seqId;
    private String hintText;

    private NewHintAdded(String mcqId,int seqId,String hintText){
        this.mcqId = mcqId;
        this.seqId = seqId;
        this.hintText = hintText;
    }


    public static NewHintAdded of(String mcqId, int seqId, String hintText) {
        NewHintAdded evt = new NewHintAdded(mcqId,seqId,hintText);
        return evt;
    }
}
