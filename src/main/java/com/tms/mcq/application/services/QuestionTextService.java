package com.tms.mcq.application.services;

import com.tms.mcq.application.ports.in.QuestionTextUseCase;
import com.tms.mcq.application.ports.in.commands.AddOrUpdateQuestionTextCmd;
import com.tms.mcq.application.ports.out.MCQRepository;
import com.tms.mcq.domain.model.MCQ;
import com.tms.mcq.exception.MCQErrorCode;
import com.tms.mcq.exception.MCQException;
import com.tms.mcq.framework.annotation.CommandHandler;
import com.tms.mcq.framework.annotation.UseCaseService;
import com.tms.mcq.framework.dto.ServiceResult;
import com.tms.mcq.framework.utils.ResponseKey;
import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Transactional;

@UseCaseService
public class QuestionTextService implements QuestionTextUseCase {

    MCQRepository mcqRepository;

    @Override
    @CommandHandler
    @Transactional
    public ServiceResult upsertQuestionText(AddOrUpdateQuestionTextCmd cmd) {
       ServiceResult result = new ServiceResult();
       MCQ mcq = mcqRepository.findById(cmd.getMcqId()).get();
       if(mcq == null){
         throw new MCQException(MCQErrorCode.MCQ_20002,"No question available to edit with this Id","MCQ not found in system with this Id");
       }
       mcq.addOrUpdateQuestionText(cmd.getQuestionText());
       result.addData(ResponseKey.message,"Question is Updated");
       return result;
    }
}
