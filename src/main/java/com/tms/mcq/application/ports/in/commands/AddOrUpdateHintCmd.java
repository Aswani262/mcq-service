package com.tms.mcq.application.ports.in.commands;

import com.tms.mcq.adaptors.in.restapi.req.UpsertHintReq;
import com.tms.mcq.exception.MCQErrorCode;
import com.tms.mcq.exception.MCQException;
import com.tms.mcq.framework.annotation.UseCaseService;
import com.tms.mcq.framework.exception.ErrorInfo;
import lombok.Getter;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
public class AddOrUpdateHintCmd extends MCQCommand{

    private String mcqId;
    private int seqId;
    private String hintText;



    private AddOrUpdateHintCmd(String mcqId,int seqId,String hintText){
        this.mcqId = mcqId;
        this.seqId = seqId;
        this.hintText = hintText;

    }

    public static AddOrUpdateHintCmd from(String mcqId, UpsertHintReq req) {
        validate(mcqId,req);
        AddOrUpdateHintCmd cmd = new AddOrUpdateHintCmd(mcqId, req.getSeqId(), req.getHintText());
        return cmd;
    }


    public static List<ErrorInfo> validate(String mcqId, UpsertHintReq hint) {

         List<ErrorInfo> errorInfos = new ArrayList<>();

         if(StringUtils.isBlank(mcqId)){
            throw new MCQException(MCQErrorCode.MCQ_10007,"Id is needed to add or update hint","MCQ Id is empty or null");
         }
         if(hint.getSeqId() == 0){
                throw new MCQException(MCQErrorCode.MCQ_10008,"Seq Id is needed to be postive no","SeqId is 0");
         }
         if(StringUtils.isBlank(hint.getHintText())){
                    throw new MCQException(MCQErrorCode.MCQ_10009,"Hint cannot empty","Hint text is missing");
         }

         return errorInfos;
    }
}
