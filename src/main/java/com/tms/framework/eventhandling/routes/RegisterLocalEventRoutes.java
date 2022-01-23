package com.tms.framework.eventhandling.routes;

import com.tms.framework.eventhandling.LocalEventRegistry;
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
public class RegisterLocalEventRoutes implements ApplicationContextAware {

    @Autowired
    CamelContext camelContext;

    @Autowired
    LocalEventRegistry eventRegistry;


    @SneakyThrows
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        for (Map.Entry<Class<?>, List<Map<String, String>>> handler : eventRegistry.getProviderMap().entrySet()) {
            String eventName = handler.getKey().getSimpleName();
            ArrayList<String> receptentList = new ArrayList<>();
            for (Map<String, String> beanAndMethod : handler.getValue()) {
                String receptent = "bean:" + beanAndMethod.get("beanName") + "?method=" + beanAndMethod.get("methodName");
                receptentList.add(receptent);
            }
            String receptedListAsString = StringUtils.join(receptentList, ",");
            camelContext.addRoutes(new LocalEventRoutes(eventName, receptedListAsString, handler.getKey()));
        }
    }
}
