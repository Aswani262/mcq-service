package com.tms.mcq.usecase.mcq;

import com.tms.framework.dto.ServiceResult;
import com.tms.mcq.usecase.mcq.commands.MCQCommand;
import lombok.Getter;
import lombok.NoArgsConstructor;

public interface RemoveAssignedYearUseCase {
    ServiceResult UnAssignYear(UnAssignYearCmd cmd);


    @Getter
    @NoArgsConstructor
    public class UnAssignYearCmd extends MCQCommand {
        private String mcqId;
        private String year;

        public static UnAssignYearCmd from(String mcqId, String year) {
            UnAssignYearCmd cmd = new UnAssignYearCmd();
            cmd.mcqId = mcqId;
            cmd.year = year;
            cmd.validate();
            return cmd;
        }

        private void validate() {

        }
    }
}
