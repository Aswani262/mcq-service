package com.tms.mcq.usecase.subject;

import com.tms.framework.annotation.UseCaseService;
import com.tms.framework.dto.ServiceResult;

@UseCaseService
public class AddNewSubjectService implements AddNewSubjectUseCase{
    @Override
    public ServiceResult addNewSubject(AddNewSubject cmd) {
        return null;
    }
}
