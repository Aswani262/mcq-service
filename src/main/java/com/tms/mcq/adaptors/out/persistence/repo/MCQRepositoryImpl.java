package com.tms.mcq.adaptors.out.persistence.repo;

import com.tms.mcq.application.ports.out.MCQRepository;
import org.springframework.data.mongodb.core.MongoTemplate;

public class MCQRepositoryImpl implements MCQRepository {

    MongoTemplate template;

    public MCQRepositoryImpl(MongoTemplate template){
        this.template = template;
    }

}
