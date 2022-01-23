package com.tms.tasks.usecase;

import com.tms.framework.annotation.UseCaseService;
import com.tms.framework.commandhandling.Dispatcher;
import com.tms.framework.dto.ServiceResult;
import com.tms.sylllabus.domain.Syllabus;

@UseCaseService
public class AutomaticallyRoadmapForBatchService implements AutomaticallyRoadmapForBatchUseCase {

    private final Dispatcher localDispatcher;

    public AutomaticallyRoadmapForBatchService(Dispatcher localDispatcher) {
        this.localDispatcher = localDispatcher;
    }

    @Override
    public ServiceResult generateRoadmapForBatch(GenerateNewRoadMapForBatch cmd) {
        ServiceResult result = new ServiceResult();
        Syllabus  syllabus = getSyllabus(cmd.getTargetExam());
        return null;
    }

    private Syllabus getSyllabus(String targetExam) {
        return null;
    }
}
