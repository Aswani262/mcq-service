package com.tms.mcq.application.ports.in.commands;

import com.tms.mcq.exception.MCQErrorCode;
import com.tms.mcq.exception.MCQException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UpsertYearCmd extends MCQCommand{
    private String year;
    private String mcqId;

    public static UpsertYearCmd from(String mcqId, String year) {
        UpsertYearCmd cmd = new UpsertYearCmd(year,mcqId);
        cmd.validate();
        return cmd;
    }

    public void validate() {
        if(StringUtils.isBlank(this.mcqId)){
            throw new MCQException(MCQErrorCode.MCQ_10014,"MCQ Id is need to add or update year","MCQ Id is empty");
        }
        if(StringUtils.isBlank(this.year)){
            throw new MCQException(MCQErrorCode.MCQ_10015,"Year cannot be added","Year is empty");
        }
    }
}
