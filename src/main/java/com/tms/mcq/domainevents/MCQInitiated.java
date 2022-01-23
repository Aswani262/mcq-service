package com.tms.mcq.domainevents;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MCQInitiated extends MCQDomainEvent {
    private String mcqId;
}
