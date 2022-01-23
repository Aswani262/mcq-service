package com.tms.mcq.restapi.mcq.req;

import lombok.Data;

@Data
public class UnAssignLabelReq {
    private String mcqId;
    private String label;
}
