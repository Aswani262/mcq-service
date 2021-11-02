package com.tms.mcq.framework.eventhandling.routes;


import org.apache.camel.builder.RouteBuilder;

public class LocalEventRoutes extends RouteBuilder {

    private String sedaName;//Name of event
    private String receptedList;
    private Class<?> conveter;

    public LocalEventRoutes(String sedaName,String receptedList,Class<?> conveter){
        this.sedaName = sedaName;
        this.receptedList = receptedList;
        this.conveter = conveter;
    }

    @Override
    public void configure() throws Exception {
        from("seda:"+sedaName).convertBodyTo(conveter).recipientList(constant(receptedList)).parallelProcessing().end();
    }
}
