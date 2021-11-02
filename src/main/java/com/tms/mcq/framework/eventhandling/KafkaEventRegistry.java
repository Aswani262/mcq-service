package com.tms.mcq.framework.eventhandling;

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
public class KafkaEventRegistry {

    //Topic configuration
    Map<String,List<String>> providerMap = new HashMap<>();

    @Autowired
    public KafkaEventRegistry(ApplicationContext applicationContext){
        List<String> listOfEvent = new ArrayList<>();
        listOfEvent.add("MCQInitiated");
        providerMap.put("mcq-cmd-domain-event",listOfEvent);
    }

}
