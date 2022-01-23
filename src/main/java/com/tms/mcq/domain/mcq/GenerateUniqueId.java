package com.tms.mcq.domain.mcq;

import com.tms.framework.annotation.DomainService;

@DomainService
public class GenerateUniqueId {

    //SequenceService sequenceService;

    //public GenerateUniqueId(SequenceService sequenceService) {
      //  this.sequenceService = sequenceService;
   // }

    /**
     * Generate unique sequenced mcq id using prefix ,
     * retry when connection to db is failed
     *
     * @param subjectId
     * @return
     */
    public String generateMCQId(String subjectId) {
        String mcqId = "";
        //Long seq = sequenceService.getNextSequence(subjectId);
        mcqId = subjectId + "-" + "";
        return mcqId;
    }

}
