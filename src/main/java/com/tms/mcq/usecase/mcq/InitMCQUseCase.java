package com.tms.mcq.usecase.mcq;

import com.tms.framework.dto.ServiceResult;
import com.tms.mcq.exception.MCQErrorCode;
import com.tms.mcq.exception.MCQException;
import com.tms.mcq.restapi.mcq.req.InitNewMCQReq;
import com.tms.mcq.usecase.mcq.commands.MCQCommand;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

public interface InitMCQUseCase {
    //We have to identied service result and use case result data and service
    // at present my thinking is like use is full fill by some service. so it ok to return service result
    // but if you think in another way , we can do something like this
    // A use case implementation service ( XXXXUseCaseImpl )which return UseCase result because that one only serve the
    // purpose to provide implementation of use case. and other service which provide their service to XXXUseCaseImpl will
    // return Service result. I will decide later , which one is better.
    // XXXUseCase can be seen as application service - the entry point in application
    ServiceResult init(InitNewMCQCmd cmd);

    ServiceResult submitMCQ(SubmitMCQForApprovalUseCase.SubmitMCQ cmd);


    @Getter
    @NoArgsConstructor
    public class InitNewMCQCmd extends MCQCommand {
        private String orgCode;
        private String subjectId;

        /**
         * Factory method to build InitNewMCQCmd from request
         * its also do the structural validation of command
         *
         * @param req
         * @return
         */
        public static InitNewMCQCmd from(InitNewMCQReq req) {
            InitNewMCQCmd cmd = new InitNewMCQCmd();
            cmd.orgCode = req.getOrgCode();
            cmd.subjectId = req.getSubjectId();
            cmd.validate();
            return cmd;
        }
        public void validate(){
            if(StringUtils.isBlank(this.subjectId)){
                throw new MCQException(MCQErrorCode.MCQ_10_001,"Subject Id cannot be empty","Invalid subject Id");
            }
        }
    }

}
