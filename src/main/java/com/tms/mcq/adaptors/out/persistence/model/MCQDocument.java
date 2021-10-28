package com.tms.mcq.adaptors.out.persistence.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("mcq")
public class MCQDocument {
    private String id;
    private String mcqId;

}
