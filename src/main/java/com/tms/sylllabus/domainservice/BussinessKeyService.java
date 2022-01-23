package com.tms.sylllabus.domainservice;

import com.tms.framework.annotation.DomainService;

@DomainService
public class BussinessKeyService {

    public boolean isUniqueKey(String syllabus, String syllabusKey) {

        return true;
    }

    public String generateNewKey(String keyEntity) {




        return "";
    }

    public int getNewSequence(String entityCode) {
        //Seacrh for code , if not found create one

        return 0;
    }
}
