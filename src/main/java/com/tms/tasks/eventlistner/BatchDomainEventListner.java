package com.tms.tasks.eventlistner;

import com.tms.batch.domainevents.BatchCreated;
import com.tms.framework.commandhandling.Dispatcher;
import com.tms.framework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
public class BatchDomainEventListner {

    private final Dispatcher localDispacher;

    public BatchDomainEventListner(Dispatcher localDispacher) {
        this.localDispacher = localDispacher;
    }


    @EventHandler
    public void handleOnBatchCreated(BatchCreated batchCreated){




    }
}
