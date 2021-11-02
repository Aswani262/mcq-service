package com.tms.mcq.adaptors.out.persistence.repo;

import com.tms.mcq.adaptors.out.persistence.model.Sequence;
import com.tms.mcq.application.ports.out.SequenceService;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.*;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class SequenceServiceImpl implements SequenceService {

    MongoTemplate template;

    public SequenceServiceImpl(MongoTemplate template){
        this.template = template;
    }


    @Override
    public Long getNextSequence(String code) {
            Query query = new Query();
            query.addCriteria(Criteria.where("_id").is(code));
            Update update = new Update();
            update.inc("seq");
            Sequence sequence = this.template.findAndModify(query, update, new FindAndModifyOptions().returnNew(true), Sequence.class);
            return sequence.getSeq();
    }
}
