package com.tms.mcq.framework.commandhandling.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommandRoutes extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("seda:microservicename-cmd").routeId("command-route").toD("bean:${headers.toBean}");
    }
}
