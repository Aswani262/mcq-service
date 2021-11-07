package com.tms.mcq.application.ports.in.commands;

import com.tms.mcq.adaptors.in.restapi.req.OptionUpsertReq;
import com.tms.mcq.exception.MCQErrorCode;
import com.tms.mcq.exception.MCQException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UpsertOptionCmd extends MCQCommand {
    private String mcqId;
    private String optionText;
    private int seqId;
    private boolean isAns;


    public static UpsertOptionCmd from(String mcqId, OptionUpsertReq request) {
        UpsertOptionCmd cmd = new UpsertOptionCmd(mcqId, request.getOptionText(), request.getSeqId(), request.isAnswer());
        cmd.validate();
        return cmd;
    }

    public void validate() {
        if (StringUtils.isBlank(this.mcqId)) {
            throw new MCQException(MCQErrorCode.MCQ_10012, "Question Id is need for creating or updating an option", "MCQ Id is empty");
        }
        if (StringUtils.isBlank(this.optionText)) {
            throw new MCQException(MCQErrorCode.MCQ_10013, "Option is need for creating or updating an option", "Option Text is empty");

        }
    }
}
