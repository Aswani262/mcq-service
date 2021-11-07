package com.tms.mcq.adaptors.in.eventlistener;

import com.tms.mcq.domain.events.MCQInitiated;
import com.tms.mcq.framework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

/**
 * It listen for external event of orther microservice which is its interested
 */
@Component
public class ExternalEventListener {

    @EventHandler
    public void handleMCQInit(MCQInitiated mcqInisited) {
        System.out.println(mcqInisited);
    }


}
