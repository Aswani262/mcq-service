package com.tms.mcq.application.ports.out;

import com.tms.mcq.application.ports.in.commands.AddNewMCQCmd;
import com.tms.mcq.domain.model.MCQ;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MCQRepository {
    void store(MCQ mcq);

    Optional<MCQ> findById(String mcqId);
}
