package com.tms.mcq.framework.commandhandling;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    @Autowired
    CommandGateway commandGateway(ProducerTemplate template){
        DistributedCommandGateway commandGateway = new DistributedCommandGateway(template);
        return commandGateway;
    }
}
