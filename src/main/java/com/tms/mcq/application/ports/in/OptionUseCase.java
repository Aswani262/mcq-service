package com.tms.mcq.application.ports.in;

import com.tms.mcq.application.ports.in.commands.UpsertOptionCmd;
import com.tms.mcq.framework.dto.ServiceResult;

public interface OptionUseCase {

    ServiceResult upsertOption(UpsertOptionCmd cmd);
}
