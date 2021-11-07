package com.tms.mcq.adaptors.out.outboundservice.masterdata.cmd;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ValidateMasterData extends IntegrationCommand {
    private String topicId;
    private String subjectId;

    public static ValidateMasterData from(String subjectId, String topicId) {
        ValidateMasterData masterData = new ValidateMasterData(topicId, subjectId);
        return masterData;
    }
}
