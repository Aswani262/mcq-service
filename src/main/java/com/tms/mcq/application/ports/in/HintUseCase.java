package com.tms.mcq.application.ports.in;

import com.tms.mcq.application.ports.in.commands.AddOrUpdateHintCmd;
import com.tms.mcq.framework.dto.ServiceResult;

public interface HintUseCase {

    /**
     * Add hint in MCQ if SeqId not present
     * Update if SeqId present.
     *
     * @param cmd
     * @return
     */
    public ServiceResult upsertHint(AddOrUpdateHintCmd cmd);
}
