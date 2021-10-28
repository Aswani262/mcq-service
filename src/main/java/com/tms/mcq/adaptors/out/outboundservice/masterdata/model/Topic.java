package com.tms.mcq.adaptors.out.outboundservice.masterdata.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Topic {
    private String name;
    private String description;
}
