package com.tms.mcq.adaptors.in.restapi.req;

import lombok.Data;

@Data
public class UpsertHintReq {
    private int seqId;
    private String hintText;
}
