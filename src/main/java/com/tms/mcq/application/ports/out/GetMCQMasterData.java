package com.tms.mcq.application.ports.out;

import com.tms.mcq.adaptors.out.outboundservice.masterdata.cmd.GetMasterData;
import com.tms.mcq.adaptors.out.outboundservice.masterdata.cmd.GetSubjectById;
import com.tms.mcq.framework.dto.ServiceResult;

public interface GetMCQMasterData {
    public ServiceResult getMasterData(GetMasterData query);
}
