package com.tms.sylllabus.usecase;

import com.tms.framework.commandhandling.Command;
import com.tms.framework.dto.ServiceResult;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

public interface AddNewSectionUseCase {

    ServiceResult addNewSection(AdNewSection cmd);

    @Getter
    @NoArgsConstructor
    class AdNewSection extends Command {
        private String heading;
        private String subjectTypeId;
        private String subjectCode;
        private Set<String> topicTypeId;
        private String syllabusId;

    }
}
