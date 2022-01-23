package com.tms.mcq.persistence;

import com.tms.mcq.domain.mcq.MCQ;

import java.util.Optional;

public interface MCQRepository {
    void store(MCQ mcq);

    Optional<MCQ> findById(String mcqId);
}
