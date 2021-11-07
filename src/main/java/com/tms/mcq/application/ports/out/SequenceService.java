package com.tms.mcq.application.ports.out;

//Some thought on implementing out-port (secondary - adaptor)
//- One way - Implementing like GetMCQMasterData - that will make more interface and which not to useful
//- SecondWay - SequenceService - because in this case other than use case implemention are generic and small and
// more related to common logic - these are not a application service
// I will prefer to do in Second way
// Will decide later
// In case of implementing use
public interface SequenceService {
    /**
     * Get next sequence for a subject , using subject code
     *
     * @param subjectCode
     * @return next sequence
     */
    Long getNextSequence(String subjectCode);
}
