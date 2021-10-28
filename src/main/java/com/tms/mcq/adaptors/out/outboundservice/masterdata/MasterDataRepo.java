package com.tms.mcq.adaptors.out.outboundservice.masterdata;

import com.tms.mcq.adaptors.out.outboundservice.masterdata.model.MasterData;
import com.tms.mcq.adaptors.out.outboundservice.masterdata.query.GetMasterData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

@Repository
public class MasterDataRepo {
//    @Autowired
//    WebClient webClient;
    public MasterData findMasterData(GetMasterData query) {
        return new MasterData();
    }
}
