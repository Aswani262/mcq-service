package com.tms.framework.eventhandling.routes;

import org.apache.camel.builder.RouteBuilder;

public class KafkaEventsRoutes //extends RouteBuilder
 {

    private String topicName;

    public KafkaEventsRoutes(String topicName) {
        this.topicName = topicName;
    }

//    @Override
//    public void configure() throws Exception {
//        from("kafka:" + topicName + "?groupId=mcq-events&brokers=localhost:29092").toD("seda:" + "${header.eventName}");
//    }
}
