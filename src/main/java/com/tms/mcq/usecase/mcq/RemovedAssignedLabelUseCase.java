package com.tms.mcq.usecase.mcq;

import com.tms.framework.dto.ServiceResult;
import com.tms.mcq.exception.MCQErrorCode;
import com.tms.mcq.exception.MCQException;
import com.tms.mcq.usecase.mcq.commands.MCQCommand;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public interface RemovedAssignedLabelUseCase {

    ServiceResult unAssignLabel(UnAssingLable cmd);

    @Getter
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public class UnAssingLable extends MCQCommand {
        private String mcqId;
        private String label;


        public static UnAssingLable from(String mcqId, String label) {
            UnAssingLable cmd  = new UnAssingLable();
            cmd.label = label;
            cmd.mcqId = mcqId;
            Map<MCQErrorCode,String> errors = cmd.validate();
            if(!errors.isEmpty()){
                throw new MCQException(null,"","");
            }
            return cmd;
        }

        public Map<MCQErrorCode, String> validate(){
            Map<MCQErrorCode , String> errors  = new HashMap<>();
            if(StringUtils.isBlank(mcqId)){
                errors.put(MCQErrorCode.MCQ_10_009,"MCQ Id is empty");
            }
            if(StringUtils.isBlank(label)){
                errors.put(MCQErrorCode.MCQ_10_010,"MCQ Id is empty");
            }
            return errors;
        }
    }
}
