package com.tms.mcq.domain.events;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class NewYearAssigned extends MCQUpdated {
    private String mcqId;
    private String year;

    public static NewYearAssigned of(String mcqId, String year) {
        NewYearAssigned evt = new NewYearAssigned(mcqId, year);
        return evt;
    }
}
