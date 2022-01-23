package com.tms.tasks.outboundservices.syllabus;

import com.tms.framework.annotation.IntegrationService;
import com.tms.framework.dto.ServiceResult;

@IntegrationService
public class SyllabusServiceProxy {

    private final SyllabusProxyRepository syllabusProxyRepository;

    public SyllabusServiceProxy(SyllabusProxyRepository syllabusProxyRepository) {
        this.syllabusProxyRepository = syllabusProxyRepository;
    }

    public ServiceResult getSyllabusForExam(String targetExam){
        ServiceResult result = new ServiceResult();
        syllabusProxyRepository.findSyllabusByExam(targetExam);
        return result;
    }
}
