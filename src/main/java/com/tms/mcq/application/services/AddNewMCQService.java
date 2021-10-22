package com.tms.mcq.application.services;

import com.tms.mcq.application.ports.in.AddNewMCQUseCase;
import com.tms.mcq.application.ports.out.MCQRepository;

public class AddNewMCQService implements AddNewMCQUseCase {

    private MCQRepository mcqRepository;

    public AddNewMCQService(MCQRepository mcqRepository){
        this.mcqRepository = mcqRepository;
    }
}
