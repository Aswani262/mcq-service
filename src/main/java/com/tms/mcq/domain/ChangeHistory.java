package com.tms.mcq.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ChangeHistory {
    private String createdBy;
    private String lastUpdadteBy;
    private LocalDateTime createDateTime;
    private LocalDateTime lastUpdatedDateTime;
}
