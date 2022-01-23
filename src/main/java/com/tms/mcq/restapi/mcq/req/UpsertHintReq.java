package com.tms.mcq.restapi.mcq.req;

import lombok.Data;

@Data
public class UpsertHintReq {
    private int seqId;
    private String hintText;
    private Integer hintId;
}
