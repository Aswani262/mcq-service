package com.tms.mcq.usecase.subject;

import com.tms.framework.dto.ServiceResult;
import com.tms.mcq.usecase.mcq.commands.MCQCommand;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

public interface AddNewSubjectUseCase {

    ServiceResult addNewSubject(AddNewSubject cmd);

    @Getter
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    class AddNewSubject extends MCQCommand {
        private String name;
        private String description;


    }
}
