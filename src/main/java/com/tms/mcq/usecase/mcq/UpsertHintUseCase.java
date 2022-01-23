package com.tms.mcq.usecase.mcq;

import com.tms.framework.dto.ServiceResult;
import com.tms.mcq.exception.MCQErrorCode;
import com.tms.mcq.exception.MCQException;
import com.tms.mcq.restapi.mcq.req.UpsertHintReq;
import com.tms.mcq.usecase.mcq.commands.MCQCommand;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

public interface UpsertHintUseCase {


    /**
     * Add hint in MCQ if SeqId not present
     * Update if SeqId present.
     *
     * @param cmd
     * @return
     */
    public ServiceResult upsertHint(AddOrUpdateHintCmd cmd);

    @Getter
    public static class AddOrUpdateHintCmd extends MCQCommand {
        private String mcqId;
        private String hint;

        private AddOrUpdateHintCmd(String mcqId,String hintText) {
            this.mcqId = mcqId;
            this.hint = hintText;
        }

        public static AddOrUpdateHintCmd from(String mcqId, UpsertHintReq req) {
            AddOrUpdateHintCmd cmd = new AddOrUpdateHintCmd(mcqId,req.getHintText());
            cmd.validate();
            return cmd;
        }

        private void validate() {
            if (StringUtils.isBlank(this.mcqId)) {
                throw new MCQException(MCQErrorCode.MCQ_10_007, "Id is needed to add or update hint", "MCQ Id is empty or null");
            }
            if (StringUtils.isBlank(this.hint)) {
                throw new MCQException(MCQErrorCode.MCQ_10_007, "Hint is empty","");
            }
        }
    }
}
