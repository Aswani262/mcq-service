package com.tms.sylllabus.usecase;

import com.tms.framework.annotation.UseCaseService;
import com.tms.framework.dto.ServiceResult;
import com.tms.sylllabus.domain.Syllabus;
import com.tms.sylllabus.exception.SyllabusException;
import com.tms.sylllabus.persistence.SyllabusRepository;
import org.apache.commons.lang3.ObjectUtils;

@UseCaseService
public class AssignSectionToSyllabusService implements AssignSectionToSyllabusUseCase{
    private final SyllabusRepository syllabusRepository;

    public AssignSectionToSyllabusService(SyllabusRepository syllabusRepository) {
        this.syllabusRepository = syllabusRepository;
    }

    @Override
    public ServiceResult assignSectionToSyllabus(AssignSectionToSyllabus cmd) {
        ServiceResult result = new ServiceResult();
        Syllabus syllabus = syllabusRepository.findById(cmd.getSyllabusId());
        if(ObjectUtils.isEmpty(syllabus)){
            throw new SyllabusException("3.10001","Unable to assign section to syllabus","No syllabus exist");
        }
        syllabus.linkChildSection(cmd.getSectionId());
        return result;
    }
}
