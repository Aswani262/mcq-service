package com.tms.mcq.adaptors.out.outboundservice.masterdata;

import com.tms.mcq.adaptors.out.outboundservice.masterdata.cmd.GetMasterData;
import com.tms.mcq.adaptors.out.outboundservice.masterdata.model.MasterData;
import com.tms.mcq.application.ports.out.GetMCQMasterData;
import com.tms.mcq.framework.exception.ErrorCode;
import com.tms.mcq.framework.exception.TMSException;
import com.tms.mcq.framework.utils.MessageCode;
import com.tms.mcq.framework.annotation.IntegrationService;
import com.tms.mcq.framework.annotation.CommandHandler;
import com.tms.mcq.framework.dto.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import java.util.concurrent.TimeoutException;

/**
 * Just a ACL for microservice act as a proxy
 */
@IntegrationService // calling outer service
public class MasterDataServiceProxy implements GetMCQMasterData {

    @Autowired
    MasterDataRepo masterDataRepo;
    //TODO: Maintain local cache here - simply spring cache
    //Redis cache will be for query services
    //Cache update is done by event listener - time to live cache is 24 hours for master
    // data , as master data not updating to much
    @CommandHandler
    @Cacheable("masterData") // no need to use cache , as it become unmanagable
    // How - 5 Service calling the master data , and every service caching these data
    // So all the service have not in sync and its become complecate to manage
    // We can use distributed cache to maintain it
    // Distributed cache is mantain by the query to serve fastly
    public ServiceResult getMasterData(GetMasterData query){
        ServiceResult serviceResult = new ServiceResult();
        MasterData masterData = null;
        try {
            masterData = masterDataRepo.findAllMasterData();
        } catch (Throwable throwable){

        }
        return serviceResult;
    }


}
