package com.tms.mcq.framework.eventhandling;

import com.tms.mcq.framework.annotation.CommandHandler;
import com.tms.mcq.framework.commandhandling.Command;
import lombok.Getter;
import org.apache.commons.text.WordUtils;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.reflections.util.ConfigurationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.*;

@Component
@Getter
public class EventRegistry {

    Map<Class<?>, List<Map<String,String>>> providerMap = new HashMap<>();

    @Autowired
    public EventRegistry(ApplicationContext applicationContext){
        Reflections reflections = new Reflections(new ConfigurationBuilder().forPackages("com.tms.mcq").addScanners(Scanners.MethodsAnnotated));
        Set<Method> methodSet = reflections.getMethodsAnnotatedWith(EventHandler.class);

        for(Method method:methodSet){
            Class<?> parameterType = method.getParameterTypes()[0];
            Class<?> declaringClass = method.getDeclaringClass();
            String className = declaringClass.getSimpleName();
            String beanName = WordUtils.uncapitalize(className);
            String methodName = method.getName();

            HashMap<String,String> methodAndBean = new HashMap<>(2);
            methodAndBean.put("beanName",beanName);
            methodAndBean.put("methodName",methodName);
            if(providerMap.containsKey(parameterType)){
                providerMap.get(parameterType).add(methodAndBean);
            } else {
                List<Map<String,String>> receptentList = new ArrayList<>();
                receptentList.add(methodAndBean);
                providerMap.put(parameterType,receptentList);
            }
        }
    }

    public List<Map<String, String>> getBeanNameAndMethodName(Command command) {
        return providerMap.get(command.getClass());
    }
}
