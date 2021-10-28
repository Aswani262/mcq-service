package com.tms.mcq.framework.eventhandling.routes;

import com.tms.mcq.framework.eventhandling.EventRegistry;
import org.apache.camel.builder.RouteBuilder;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EventsRoutes extends RouteBuilder {

    private String sedaName;
    private String receptionList;

    public EventsRoutes(String sedaName,String receptionList){
        this.sedaName = sedaName;
        this.receptionList = receptionList;
    }


    @Override
    public void configure() throws Exception {

        from("seda:"+sedaName).recipientList(constant(receptentListString)).parallelProcessing().end();
    }
}
