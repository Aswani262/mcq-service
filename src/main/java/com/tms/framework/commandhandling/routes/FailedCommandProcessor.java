package com.tms.framework.commandhandling.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;


public class FailedCommandProcessor implements Processor {


    @Override
    public void process(Exchange exchange) throws Exception {
        //save to db
    }
}
