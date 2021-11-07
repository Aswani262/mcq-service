package com.tms.mcq.application.services;

import com.tms.mcq.application.ports.in.AssignOrUnassignLabelUseCase;
import com.tms.mcq.application.ports.in.commands.AssignLabel;
import com.tms.mcq.application.ports.out.MCQRepository;
import com.tms.mcq.domain.model.LabelRef;
import com.tms.mcq.domain.model.MCQ;
import com.tms.mcq.framework.annotation.CommandHandler;
import com.tms.mcq.framework.annotation.UseCaseService;
import com.tms.mcq.framework.dto.ServiceResult;
import com.tms.mcq.framework.utils.ResponseKey;
import com.tms.mcq.framework.utils.ServiceUtils;
import org.springframework.transaction.annotation.Transactional;

@UseCaseService
public class LabelService implements AssignOrUnassignLabelUseCase {

    MCQRepository mcqRepository;

    public LabelService(MCQRepository mcqRepository) {
        this.mcqRepository = mcqRepository;
    }

    @Override
    @Transactional
    @CommandHandler
    public ServiceResult assignLabel(AssignLabel cmd) {
        ServiceResult result = new ServiceResult();
        try {
            MCQ mcq = mcqRepository.findById(cmd.getMcqId()).get();
            mcq.assignLabel(new LabelRef(cmd.getLabelCode()));
            mcqRepository.store(mcq);
            result.addData(ResponseKey.message, "Label assigned");

        } catch (Throwable throwable) {// TODO: Use aop to handle exception - at time of handling log request and response
            ServiceUtils.handleException(throwable);
        }
        return result;
    }
}
