package com.tms.batch.domain;

import com.tms.shared.UserRef;

public class ScheduleClasses {
    private String scheduleClassesId;
    private String heading;
    private ClassTimeing classTimeing;
    private UserRef organisedBy;
    private UserRef takenBy;
    private Frequency frequency;//Daily , Weekly , Monthly , Chose DAYS
}
