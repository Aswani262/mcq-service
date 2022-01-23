package com.tms.mcq.usecase.mcq;


import com.tms.framework.dto.ServiceResult;
import com.tms.mcq.exception.MCQErrorCode;
import com.tms.mcq.exception.MCQException;
import com.tms.mcq.usecase.mcq.commands.MCQCommand;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

public interface AssignLabelUseCase {

     ServiceResult assignLabel(AssignLabel cmd);

     @Getter
     public static class AssignLabel extends MCQCommand {
          private String mcqId;
          private String label;

          private AssignLabel(String mcqId, String labelCode) {
               this.mcqId = mcqId;
               this.label = labelCode;
          }

          //Providing a static factory method to create an Command
          public static AssignLabel from(String mcqId, String label) {
               AssignLabel cmd = new AssignLabel(mcqId, label);
               cmd.validate();
               return cmd;
          }

          //Make every command as self validation encapsulation , not using any extern validator
          public void validate() {
               if (StringUtils.isBlank(this.mcqId)) {
                    throw new MCQException(MCQErrorCode.MCQ_10_016, "Unable to assign label", "MCQ Id is empty");
               }
               if (StringUtils.isBlank(this.label)) {
                    throw new MCQException(MCQErrorCode.MCQ_10_017, "Unable to assign label", "Label is empty");
               }
          }
     }


}
