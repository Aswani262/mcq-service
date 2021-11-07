package com.tms.mcq.adaptors.out.persistence.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("mcq_subject_sequence")
public class Sequence {
    private String _id;
    private Long seq;
}
