package com.tms.mcq.framework.eventhandling.routes;

import com.tms.mcq.framework.eventhandling.KafkaEventRegistry;
import lombok.SneakyThrows;
import org.apache.camel.CamelContext;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class RegisterKafkaEventRoutes implements ApplicationContextAware {

    @Autowired
    CamelContext camelContext;

    @Autowired
    KafkaEventRegistry kafkaEventRegistry;

    @SneakyThrows
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        for (Map.Entry<String, List<String>> topics : kafkaEventRegistry.getProviderMap().entrySet()) {
            camelContext.addRoutes(new KafkaEventsRoutes(topics.getKey()));
        }
    }
}
