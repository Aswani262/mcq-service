package com.tms.mcq.restapi.mcq.req;

import lombok.Data;

@Data
public class OptionUpsertReq {
    private String optionText;
    private boolean isAnswer;
}
