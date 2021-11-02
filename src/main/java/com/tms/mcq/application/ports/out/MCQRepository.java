package com.tms.mcq.application.ports.out;

import com.tms.mcq.application.ports.in.commands.AddNewMCQCmd;
import com.tms.mcq.domain.model.MCQ;
import org.springframework.data.repository.CrudRepository;

public interface MCQRepository {
    void store(MCQ mcq);

}
