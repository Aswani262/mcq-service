package com.tms.mcq.framework.commandhandling.routes;

import com.tms.mcq.framework.exception.TMSException;
import lombok.AllArgsConstructor;
import org.apache.camel.CamelContext;
import org.apache.camel.ExchangePattern;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.annotation.Configuration;


public class CommandRoutes extends RouteBuilder {

    private CamelContext camelContext;
    private String sedaName;
    private String toBean;
    private String methodName;

    public CommandRoutes(CamelContext camelContext,String sedaName,String toBean,String methodName){
        super(camelContext);
        this.sedaName = sedaName;
        this.toBean = toBean;
        this.methodName = methodName;

    }

    @Override
    public void configure() throws Exception {

        onException(TMSException.class)
                .onWhen(exchange -> ((TMSException)exchange.getException()).isRecoverable())
                        .maximumRedeliveries(3)
                                .redeliveryDelay(1000).to("seda:mcq-cmd-dead-letter").setExchangePattern(ExchangePattern.InOnly);

        from("seda:"+ sedaName).routeId(sedaName+"-"+"route")
                .tracing().
                to("bean:"+toBean+"?method="+methodName);
    }
}
