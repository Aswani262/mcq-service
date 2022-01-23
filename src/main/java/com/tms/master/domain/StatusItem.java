package com.tms.master.domain;

import java.util.List;

public class StatusItem {
    private String statusId;
    private String statusTypeId;
    private String statusCode;
    private String description;
    private List<ToStatusValidChange> toStatusValidChanges;
}
