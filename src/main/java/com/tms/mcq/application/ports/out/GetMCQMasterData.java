package com.tms.mcq.application.ports.out;

import com.tms.mcq.adaptors.out.outboundservice.masterdata.query.GetMasterData;
import com.tms.mcq.framework.dto.ServiceResult;

public interface GetMCQMasterData {
    public ServiceResult getMasterData(GetMasterData query);
}
