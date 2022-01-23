package com.tms.sylllabus.usecase;

import com.tms.framework.annotation.CommandHandler;
import com.tms.framework.annotation.UseCaseService;
import com.tms.framework.dto.ServiceResult;
import com.tms.sylllabus.domain.Syllabus;
import com.tms.sylllabus.persistence.SyllabusRepository;
import org.springframework.transaction.annotation.Transactional;

@UseCaseService
public class AddSyllabusService implements AddSyllabusUseCase{

    private final SyllabusRepository syllabusRepository;

    public AddSyllabusService(SyllabusRepository syllabusRepository) {
        this.syllabusRepository = syllabusRepository;
    }

    @Override
    @CommandHandler
    @Transactional
    public ServiceResult addNewSyllabus(AddSyllabus cmd) {
        ServiceResult result = new ServiceResult();
        Syllabus syllabus = Syllabus.from(cmd.getHeading(),cmd.getTargetExamCode(), cmd.getTargetExamTypeId());
        syllabusRepository.store(syllabus);
        return result;
    }
}
