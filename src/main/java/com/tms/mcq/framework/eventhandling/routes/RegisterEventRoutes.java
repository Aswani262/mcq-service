package com.tms.mcq.framework.eventhandling.routes;

import com.tms.mcq.framework.eventhandling.EventRegistry;
import lombok.SneakyThrows;
import org.apache.camel.CamelContext;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class RegisterEventRoutes implements ApplicationContextAware {

    @Autowired
    CamelContext camelContext;

    @Autowired
    EventRegistry eventRegistry;


    @SneakyThrows
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        for(Map.Entry<Class<?>, List<Map<String,String>>> handler:eventRegistry.getProviderMap().entrySet()){
            String eventName = handler.getKey().getSimpleName();
            List<String> listOfRecepted = new ArrayList<>();
            for(Map<String,String> beanAndMethodName:handler.getValue()){
                String to = "bean:"+beanAndMethodName.get("beanName")+"?method="+beanAndMethodName.get("methodName");
                listOfRecepted.add(to);
            }
            String listOfRecep  = StringUtils.join(listOfRecepted,",");
            camelContext.addRoutes(new EventsRoutes(eventName,listOfRecep);
        }
    }
}
