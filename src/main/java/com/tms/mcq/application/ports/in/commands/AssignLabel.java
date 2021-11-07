package com.tms.mcq.application.ports.in.commands;

import com.tms.mcq.exception.MCQErrorCode;
import com.tms.mcq.exception.MCQException;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Getter
public class AssignLabel extends MCQCommand {
    private String mcqId;
    private String labelCode;

    private AssignLabel(String mcqId, String labelCode) {
        this.mcqId = mcqId;
        this.labelCode = labelCode;
    }

    //Providing a static factory method to create an Command
    public static AssignLabel from(String mcqId, String labelCode) {
        AssignLabel cmd = new AssignLabel(mcqId, labelCode);
        cmd.validate();
        return cmd;
    }

    //Make every command as self validation encapsulation , not using any extern validator
    public void validate() {
        if (StringUtils.isBlank(this.mcqId)) {
            throw new MCQException(MCQErrorCode.MCQ_10016, "Unable to assign label", "MCQ Id is empty");
        }
        if (StringUtils.isBlank(this.labelCode)) {
            throw new MCQException(MCQErrorCode.MCQ_10017, "Unable to assign label", "Label is empty");
        }
    }
}
