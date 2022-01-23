package com.tms.mcq.restapi.mcq.req;

import lombok.Data;

import java.util.List;

@Data
public class OptionsUpsertReq {
    List<OptionUpsertReq> options;
}
