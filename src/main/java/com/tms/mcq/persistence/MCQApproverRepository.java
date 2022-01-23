package com.tms.mcq.persistence;

import com.tms.mcq.domain.mcqapporover.MCQApprover;

import java.util.List;
import java.util.Set;

public interface MCQApproverRepository {
    List<MCQApprover> seacrhApproverBySubjectAndTopics(String subject, Set<String> topics);
}
