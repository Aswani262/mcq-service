package com.tms.mcq.adaptors.out.outboundservice.masterdata.model;

import lombok.*;

@EqualsAndHashCode
@Data
public class Topic {
    private String code;//This is primary key
    private String name;
}
