package com.tms.mcq.framework.job;

import lombok.Getter;
import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

@Getter
public class JobEntity {
    private String from;
    private Exchange exchange;
}
