package com.tms.mcq.framework.eventhandling;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Getter
public class KafkaEventRegistry {

    //Topic configuration
    Map<String, List<String>> providerMap = new HashMap<>();

    @Autowired
    public KafkaEventRegistry(ApplicationContext applicationContext) {
        List<String> listOfEvent = new ArrayList<>();
        listOfEvent.add("MCQInitiated");
        providerMap.put("mcq-cmd-domain-event", listOfEvent);
    }

}
