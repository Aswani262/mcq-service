package com.tms.tasks.outboundservices.syllabus;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class SyllabusProxyRepository {

    private final RestTemplate restTemplate;

    public SyllabusProxyRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public void findSyllabusByExam(String targetExam) {


    }
}
