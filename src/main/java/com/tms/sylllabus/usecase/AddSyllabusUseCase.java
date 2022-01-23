package com.tms.sylllabus.usecase;

import com.tms.framework.commandhandling.Command;
import com.tms.framework.dto.ServiceResult;
import lombok.Getter;
import lombok.NoArgsConstructor;

public interface AddSyllabusUseCase {

    ServiceResult addNewSyllabus(AddSyllabus cmd);

    @Getter
    @NoArgsConstructor
    class AddSyllabus extends Command {
        private String heading;
        private String targetExamTypeId;
        private String targetExamCode;
        private String orgCode;
    }
}
