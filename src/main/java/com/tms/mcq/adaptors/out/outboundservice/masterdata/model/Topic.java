package com.tms.mcq.adaptors.out.outboundservice.masterdata.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Data
public class Topic {
    private String code;//This is primary key
    private String name;
}
