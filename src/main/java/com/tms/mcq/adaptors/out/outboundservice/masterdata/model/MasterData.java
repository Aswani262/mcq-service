package com.tms.mcq.adaptors.out.outboundservice.masterdata.model;

import lombok.Data;

import java.util.Set;

@Data
public class MasterData {
    private Set<Topic> topics;
    private Set<Subject> subject;
    private Set<Label> labels;
}
