package com.tms.mcq.servicehelpers;

import com.tms.mcq.domain.mcq.MCQ;
import com.tms.mcq.domain.mcqapporover.MCQApprover;
import com.tms.mcq.persistence.MCQApproverRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class MCQApproverServiceHelpers {

    MCQApproverRepository mcqApproverRepository;
    MCQServiceHelper mcqServiceHelper;

    public List<MCQApprover> findAprroverByMCQId(String mcqId) {
       MCQ mcq = mcqServiceHelper.findMCQById(mcqId);

       String subject = mcq.getSubject();
       Set<String> topics = mcq.getTopics();

       List<MCQApprover> mcqApprovers = mcqApproverRepository.seacrhApproverBySubjectAndTopics(subject,topics);

       return mcqApprovers;

    }
}
