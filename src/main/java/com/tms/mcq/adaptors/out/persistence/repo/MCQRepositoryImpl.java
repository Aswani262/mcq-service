package com.tms.mcq.adaptors.out.persistence.repo;

import com.tms.mcq.application.ports.out.MCQRepository;
import com.tms.mcq.domain.model.MCQ;

import com.tms.mcq.framework.exception.ErrorCode;
import com.tms.mcq.framework.exception.TMSException;
import com.tms.mcq.framework.utils.MessageCode;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class MCQRepositoryImpl implements MCQRepository {

    private final String table_name = "mcq";

    MongoTemplate mongoTemplate;

    public MCQRepositoryImpl(MongoTemplate jdbcTemplate){
        this.mongoTemplate = jdbcTemplate;
    }

    @Override
    public void store(MCQ mcq) {
        try {
            mongoTemplate.save(mcq, table_name);
        } catch (Throwable throwable){

        }
    }


}
