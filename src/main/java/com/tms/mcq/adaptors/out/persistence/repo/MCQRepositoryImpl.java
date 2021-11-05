package com.tms.mcq.adaptors.out.persistence.repo;

import com.tms.mcq.application.ports.out.MCQRepository;
import com.tms.mcq.domain.model.MCQ;

import com.tms.mcq.framework.exception.ErrorCode;
import com.tms.mcq.framework.exception.TMSException;
import com.tms.mcq.framework.utils.MessageCode;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public class MCQRepositoryImpl implements MCQRepository {

    private final String table_name = "mcq";

    MongoTemplate mongoTemplate;

    public MCQRepositoryImpl(MongoTemplate jdbcTemplate){
        this.mongoTemplate = jdbcTemplate;
    }

    @Override
    public void store(MCQ mcq) {
        mongoTemplate.save(mcq, table_name);
    }

    @Override
    public Optional<MCQ> findById(String mcqId) {
      Optional<MCQ> mcq =  Optional.of(mongoTemplate.findById(mcqId,MCQ.class,table_name));
      return mcq;
    }
}
