package com.tms.mcq.usecase.mcq;

import com.tms.framework.dto.ServiceResult;
import com.tms.mcq.exception.MCQErrorCode;
import com.tms.mcq.exception.MCQException;
import com.tms.mcq.usecase.mcq.commands.MCQCommand;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

public interface AssignYearUseCase {

    ServiceResult assignYear(AssignYearCmd cmd);


    @Getter
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class AssignYearCmd extends MCQCommand {
        private String year;
        private String mcqId;

        public static AssignYearCmd from(String mcqId, String year) {
            AssignYearCmd cmd = new AssignYearCmd(year, mcqId);
            cmd.validate();
            return cmd;
        }

        public void validate() {
            if (StringUtils.isBlank(this.mcqId)) {
                throw new MCQException(MCQErrorCode.MCQ_10_014, "MCQ Id is need to add or update year", "MCQ Id is empty");
            }
            if (StringUtils.isBlank(this.year)) {
                throw new MCQException(MCQErrorCode.MCQ_10_015, "Year cannot be added", "Year is empty");
            }
        }
    }
}
