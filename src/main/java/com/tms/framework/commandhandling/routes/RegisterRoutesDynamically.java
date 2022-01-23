package com.tms.framework.commandhandling.routes;

import com.tms.framework.commandhandling.CommandRegistry;
import lombok.SneakyThrows;
import org.apache.camel.CamelContext;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component
public class RegisterRoutesDynamically implements ApplicationContextAware {

    @Autowired
    CommandRegistry registry;

    @Autowired
    CamelContext camelContext;

    @SneakyThrows
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        for (Map.Entry<Class<?>, Map<String, String>> handler : registry.getProviderMap().entrySet()) {
            Map<String, String> beanAndMethod = handler.getValue();
            camelContext.addRoutes(new CommandRoutes(camelContext, handler.getKey().getSimpleName(), beanAndMethod.get("beanName"), beanAndMethod.get("methodName")));
        }
    }
}
