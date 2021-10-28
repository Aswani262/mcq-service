package com.tms.mcq.framework.job;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SchedulerRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("seda:mcq-cmd-scheduler");
    }
}
