package com.tms.mcq.framework.commandhandling.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;


@Component
public class DeadLetterRoutes extends RouteBuilder {

    @Override
    public void configure() throws Exception {
       from("seda:mcq-cmd-dead-letter").process(new FailedCommandProcessor()).to("seda:mcq-cmd-scheduler");
    }
}
