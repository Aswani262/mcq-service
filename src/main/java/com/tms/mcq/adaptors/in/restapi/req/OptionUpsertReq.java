package com.tms.mcq.adaptors.in.restapi.req;

import lombok.Data;

@Data
public class OptionUpsertReq {
    private int seqId;
    private String optionText;
    private boolean isAnswer;
}
