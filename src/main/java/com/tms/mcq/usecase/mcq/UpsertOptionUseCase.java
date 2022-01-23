package com.tms.mcq.usecase.mcq;

import com.tms.framework.dto.ServiceResult;
import com.tms.mcq.exception.MCQErrorCode;
import com.tms.mcq.exception.MCQException;
import com.tms.mcq.restapi.mcq.req.OptionUpsertReq;
import com.tms.mcq.restapi.mcq.req.OptionsUpsertReq;
import com.tms.mcq.usecase.mcq.commands.MCQCommand;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public interface UpsertOptionUseCase {

    ServiceResult upsertOption(UpsertOptionsCmd cmd);


    @Getter
    @NoArgsConstructor
    public static class UpsertOptionsCmd extends MCQCommand {
        private String mcqId;
        List<UpsertOptionCmd> upsertOptions;

        public static UpsertOptionsCmd from(String mcqId, OptionsUpsertReq request) {
            UpsertOptionsCmd cmd = new UpsertOptionsCmd();
            List<UpsertOptionCmd> upsertOptionCmds = new ArrayList<>();
            request.getOptions().forEach(optionUpsertReq -> upsertOptionCmds.add(UpsertOptionCmd.from(mcqId,optionUpsertReq)));
            cmd.upsertOptions = upsertOptionCmds;
            cmd.mcqId = mcqId;
            return cmd;
        }
    }

    @Getter
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public class UpsertOptionCmd extends MCQCommand {

        private String optionText;
        private boolean isAns;

        public static UpsertOptionCmd from(String mcqId, OptionUpsertReq request) {
            UpsertOptionCmd cmd = new UpsertOptionCmd(request.getOptionText(), request.isAnswer());
            cmd.validate();
            return cmd;
        }

        public void validate() {

            if (StringUtils.isBlank(this.optionText)) {
                throw new MCQException(MCQErrorCode.MCQ_10_013, "Option is need for creating or updating an option", "Option Text is empty");

            }
        }
    }

}
