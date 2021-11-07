package com.tms.mcq.application.ports.in.commands;

import com.tms.mcq.exception.MCQErrorCode;
import com.tms.mcq.exception.MCQException;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class RemoveHintCmd extends MCQCommand {
    private String mcqId;
    private int seqId;

    private RemoveHintCmd(String mcqId, int seqId) {
        this.mcqId = mcqId;
        this.seqId = seqId;
    }

    public static RemoveHintCmd from(String mcqId, int seqId) {
        validate(mcqId, seqId);
        RemoveHintCmd cmd = new RemoveHintCmd(mcqId, seqId);
        return cmd;
    }

    public static void validate(String mcqId, int seqId) {
        if (StringUtils.isBlank(mcqId)) {
            throw new MCQException(MCQErrorCode.MCQ_10010, "MCQ Id is need to remove hint", "MCQ Id is empty");
        }
        if (seqId == 0) {
            throw new MCQException(MCQErrorCode.MCQ_10011, "Seq Id is need to remove hint.Must be positive value", "Seq Id is 0 ,which not a valid.");
        }
    }
}
