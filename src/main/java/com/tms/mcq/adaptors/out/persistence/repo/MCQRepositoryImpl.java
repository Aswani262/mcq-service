package com.tms.mcq.adaptors.out.persistence.repo;

import com.tms.mcq.application.ports.out.MCQRepository;
import com.tms.mcq.domain.model.MCQ;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class MCQRepositoryImpl implements MCQRepository {

    private final String collectionName = "mcq";

    MongoTemplate mongoTemplate;

    public MCQRepositoryImpl(MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void store(MCQ mcq) {
        mongoTemplate.save(mcq,collectionName);
    }



}
