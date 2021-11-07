package com.tms.mcq.framework.commandhandling;

import com.tms.mcq.framework.annotation.CommandHandler;
import lombok.Getter;
import org.apache.commons.text.WordUtils;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.reflections.util.ConfigurationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
@Getter
public class CommandRegistry {
    Map<Class<?>, Map<String, String>> providerMap = new HashMap<>();

    @Autowired
    public CommandRegistry(ApplicationContext applicationContext) {
        Reflections reflections = new Reflections(new ConfigurationBuilder().forPackages("com.tms.mcq").addScanners(Scanners.MethodsAnnotated));
        Set<Method> methodSet = reflections.getMethodsAnnotatedWith(CommandHandler.class);

        for (Method method : methodSet) {
            Class<?> parameterType = method.getParameterTypes()[0];
            Class<?> declaringClass = method.getDeclaringClass();
            String className = declaringClass.getSimpleName();
            String beanName = WordUtils.uncapitalize(className);
            String methodName = method.getName();
            HashMap<String, String> methodAndBean = new HashMap<>(2);
            methodAndBean.put("beanName", beanName);
            methodAndBean.put("methodName", methodName);
            providerMap.put(parameterType, methodAndBean);
        }
    }

    public Map<String, String> getBeanNameAndMethodName(Command command) {

        return providerMap.get(command.getClass());
    }
}
