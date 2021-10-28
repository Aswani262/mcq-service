package com.tms.mcq.adaptors.out.outboundservice.masterdata;

import com.tms.mcq.adaptors.out.outboundservice.masterdata.model.MasterData;
import com.tms.mcq.adaptors.out.outboundservice.masterdata.query.GetMasterData;
import com.tms.mcq.application.ports.out.GetMCQMasterData;
import com.tms.mcq.framework.annotation.IntegrationService;
import com.tms.mcq.framework.annotation.CommandHandler;
import com.tms.mcq.framework.dto.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Just a ACL for microservice act as a proxy
 */
@IntegrationService // calling outer service
public class MasterDataServiceProxy implements GetMCQMasterData {

    @Autowired
    MasterDataRepo masterDataRepo;

    @CommandHandler
    public ServiceResult getMasterData(GetMasterData query){
        ServiceResult serviceResult = new ServiceResult();
        MasterData masterData = null;
        try {
            masterData = masterDataRepo.findMasterData(query);
        } catch (Throwable throwable){
            serviceResult.addError("","");
        }
        serviceResult.addData("masterData",masterData);
        return serviceResult;
    }
}
