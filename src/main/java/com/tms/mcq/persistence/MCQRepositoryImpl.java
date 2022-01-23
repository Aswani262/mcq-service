package com.tms.mcq.persistence;

import com.tms.mcq.domain.mcq.MCQ;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MCQRepositoryImpl implements MCQRepository{
    @Override
    public void store(MCQ mcq) {

    }

    @Override
    public Optional<MCQ> findById(String mcqId) {
        return Optional.empty();
    }
}
