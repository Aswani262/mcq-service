package com.tms.mcq.application.ports.in.commands;

import com.tms.mcq.adaptors.in.restapi.req.UpsertHintReq;
import com.tms.mcq.exception.MCQErrorCode;
import com.tms.mcq.exception.MCQException;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Getter
public class AddOrUpdateHintCmd extends MCQCommand {
    private String mcqId;

    //In case of hint is empty or null , considered as removing hint.
    private String hint;

    private AddOrUpdateHintCmd(String mcqId, String hintText) {
        this.mcqId = mcqId;
        this.hint = hintText;
    }

    public static AddOrUpdateHintCmd from(String mcqId, UpsertHintReq req) {
        AddOrUpdateHintCmd cmd = new AddOrUpdateHintCmd(mcqId, req.getHintText());
        cmd.validate();
        return cmd;
    }

    private void validate() {
        if (StringUtils.isBlank(this.mcqId)) {
            throw new MCQException(MCQErrorCode.MCQ_10007, "Id is needed to add or update hint", "MCQ Id is empty or null");
        }
    }


//    public static List<ErrorInfo> validate(String mcqId, UpsertHintReq hint) {
//
//         List<ErrorInfo> errorInfos = new ArrayList<>();
//
//         if(StringUtils.isBlank(mcqId)){
//            throw new MCQException(MCQErrorCode.MCQ_10007,"Id is needed to add or update hint","MCQ Id is empty or null");
//         }
//         if(StringUtils.isBlank(hint.getHintText())){
//                    throw new MCQException(MCQErrorCode.MCQ_10009,"Hint cannot empty","Hint text is missing");
//         }
//
//         return errorInfos;
//    }
}
