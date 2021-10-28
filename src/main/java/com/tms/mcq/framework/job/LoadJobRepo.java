package com.tms.mcq.framework.job;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class LoadJobRepo {
    MongoTemplate mongoTemplate;

    public JobEntity getJobs() {
        return new JobEntity();
    }
}
