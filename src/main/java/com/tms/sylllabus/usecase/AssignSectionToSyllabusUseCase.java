package com.tms.sylllabus.usecase;

import com.tms.framework.dto.ServiceResult;
import lombok.Getter;
import lombok.NoArgsConstructor;

public interface AssignSectionToSyllabusUseCase {

    ServiceResult assignSectionToSyllabus(AssignSectionToSyllabus cmd);

    @Getter
    @NoArgsConstructor
    class AssignSectionToSyllabus{
        private String sectionId;
        private String syllabusId;
    }
}
