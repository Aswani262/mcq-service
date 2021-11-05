package com.tms.mcq.application.ports.in;

import com.tms.mcq.application.ports.in.commands.UpsertYearCmd;
import com.tms.mcq.framework.dto.ServiceResult;

public interface YearUseCase {

    ServiceResult upsertYear(UpsertYearCmd cmd);
}
