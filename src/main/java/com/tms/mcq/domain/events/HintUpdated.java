package com.tms.mcq.domain.events;

import com.tms.mcq.framework.eventhandling.DomainEvent;
import lombok.Getter;

@Getter
public class HintUpdated extends MCQDomainEvent{
    private String mcqId;
    private int seqId;
    private String hintText;

    private HintUpdated(String mcqId,int seqId,String hintText){
        this.mcqId = mcqId;
        this.seqId = seqId;
        this.hintText = hintText;
    }

    public static HintUpdated of(String mcqId, int seqId, String hintText) {
        HintUpdated evt = new HintUpdated(mcqId,seqId,hintText);
        return evt;
    }
}
