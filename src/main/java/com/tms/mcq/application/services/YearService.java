package com.tms.mcq.application.services;

import com.tms.mcq.application.ports.in.YearUseCase;
import com.tms.mcq.application.ports.in.commands.UpsertYearCmd;
import com.tms.mcq.application.ports.out.MCQRepository;
import com.tms.mcq.domain.model.MCQ;
import com.tms.mcq.framework.annotation.CommandHandler;
import com.tms.mcq.framework.annotation.UseCaseService;
import com.tms.mcq.framework.dto.ServiceResult;
import org.springframework.transaction.annotation.Transactional;

@UseCaseService
public class YearService implements YearUseCase {

    MCQRepository repository;

    public YearService(MCQRepository repository) {
        this.repository = repository;
    }

    @Override
    @CommandHandler
    @Transactional
    public ServiceResult upsertYear(UpsertYearCmd cmd) {
        MCQ mcq = repository.findById(cmd.getMcqId()).get();

        mcq.assignYearInAsked(cmd.getYear());

        return null;
    }
}
