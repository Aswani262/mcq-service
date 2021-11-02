package com.tms.mcq.domain.events;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MCQInitiated extends MCQDomainEvent {
    private String mcqId;
}
