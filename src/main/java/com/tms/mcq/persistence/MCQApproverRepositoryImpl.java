package com.tms.mcq.persistence;

import com.tms.mcq.domain.mcqapporover.MCQApprover;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public class MCQApproverRepositoryImpl implements MCQApproverRepository{
    @Override
    public List<MCQApprover> seacrhApproverBySubjectAndTopics(String subject, Set<String> topics) {
        return null;
    }
}
