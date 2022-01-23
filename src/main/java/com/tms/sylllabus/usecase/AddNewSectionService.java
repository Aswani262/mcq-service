package com.tms.sylllabus.usecase;

import com.tms.framework.annotation.UseCaseService;
import com.tms.framework.commandhandling.Dispatcher;
import com.tms.framework.dto.ServiceResult;
import com.tms.sylllabus.domain.Section;
import com.tms.sylllabus.domainservice.BussinessKeyService;

@UseCaseService
public class AddNewSectionService implements AddNewSectionUseCase{
    @Override
    public ServiceResult addNewSection(AdNewSection cmd) {
        return null;
    }

//   // private final SectionRepository  sectionRepository;
//    private final BussinessKeyService bussinessKeyService;
//    private final Dispatcher dispatcher;
//
//    public AddNewSectionService(SectionRepository sectionRepository, BussinessKeyService bussinessKeyService, Dispatcher dispatcher) {
//        this.sectionRepository = sectionRepository;
//        this.bussinessKeyService = bussinessKeyService;
//        this.dispatcher = dispatcher;
//    }
//
//    @Override
//    public ServiceResult addNewSection(AdNewSection cmd) {
//        ServiceResult result = new ServiceResult();
//        Section section = Section.from(bussinessKeyService,cmd.getHeading(), cmd.getSubjectTypeId(), cmd.getTopicTypeId(),cmd.getSyllabusId(),cmd.getSubjectCode());
//        sectionRepository.store(section);
//        assignSectionToSyllabus(section.getSectionId(),section.getSyllabusId());
//        return result;
//    }
//
//    private void assignSectionToSyllabus(String sectionId, String syllabusId) {
//
//    }
}
