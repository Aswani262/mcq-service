package com.tms.mcq.usecase.mcq;

import com.tms.framework.annotation.CommandHandler;
import com.tms.framework.annotation.UseCaseService;
import com.tms.framework.dto.ServiceResult;
import com.tms.framework.utils.ResponseKey;
import com.tms.mcq.domain.mcq.MCQ;
import com.tms.mcq.exception.MCQErrorCode;
import com.tms.mcq.persistence.MCQRepository;
import org.springframework.transaction.annotation.Transactional;

@UseCaseService
public class UpsertQuestionTextService implements UpsertQuestionTextUseCase {

    MCQRepository mcqRepository;

    public UpsertQuestionTextService(MCQRepository repository){
        this.mcqRepository = repository;
    }

//    @Override
//    @CommandHandler
//    @Transactional
//    public ServiceResult upsertQuestionText(AddOrUpdateQuestionTextCmd cmd) {
//        ServiceResult result = new ServiceResult();
//        MCQ mcq = mcqRepository.findById(cmd.getMcqId()).get();
//        if (mcq == null) {
//            throw new MCQNotExist(MCQErrorCode.MCQ_10_008,"Invalid MCQ Id:"+cmd.getMcqId());
//        }
//        mcq.addQuestionText(cmd.getQuestionText());
//        result.addData(ResponseKey.message, "Question is Updated");
//        return result;
//    }
}
