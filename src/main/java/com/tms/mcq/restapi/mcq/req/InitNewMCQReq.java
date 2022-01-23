package com.tms.mcq.restapi.mcq.req;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class InitNewMCQReq {
    private String orgCode;
    private String subjectId;
}
