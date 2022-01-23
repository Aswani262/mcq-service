package com.tms.tasks.usecase;

import com.tms.framework.commandhandling.Command;
import com.tms.framework.dto.ServiceResult;
import lombok.Getter;
import lombok.NoArgsConstructor;

public interface AutomaticallyRoadmapForBatchUseCase {

    ServiceResult generateRoadmapForBatch(GenerateNewRoadMapForBatch cmd);

    @Getter
    @NoArgsConstructor
    class GenerateNewRoadMapForBatch extends Command {
        private String batchKey;
        private String targetExam;
    }
}
