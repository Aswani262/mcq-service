package com.tms.mcq.domain.events;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class YearUnAssigned extends MCQUpdated {
    private String mcqId;
    private String year;

    public static YearUnAssigned of(String mcqId, String year) {
        YearUnAssigned evt = new YearUnAssigned(mcqId, year);
        return evt;
    }
}
