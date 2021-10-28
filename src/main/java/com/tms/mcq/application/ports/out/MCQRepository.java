package com.tms.mcq.application.ports.out;

import com.tms.mcq.application.ports.in.commands.AddNewMCQCmd;
import com.tms.mcq.domain.model.MCQ;

public interface MCQRepository {
    void store(MCQ mcq);

}
