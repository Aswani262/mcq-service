package com.tms.mcq.framework.job;

import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.stereotype.Component;

@Component
public class LoadJobService {

    private String tablename = "mcq-cmd-scheduler";

    private ProducerTemplate template;

    private LoadJobRepo repo;

    public void load(){
        JobEntity job = repo.getJobs();
        Exchange exchange = job.getExchange();
        exchange.isFailed();
        //template.send();

    }
}
