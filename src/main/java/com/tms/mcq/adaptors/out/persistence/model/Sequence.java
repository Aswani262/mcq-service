package com.tms.mcq.adaptors.out.persistence.model;

import com.tms.mcq.application.ports.out.SequenceService;
import jdk.jfr.DataAmount;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@Document("mcq_subject_sequence")
public class Sequence  {
    private String _id;
    private Long seq;
}
