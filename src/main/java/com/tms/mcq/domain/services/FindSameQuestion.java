package com.tms.mcq.domain.services;


import com.tms.mcq.framework.annotation.DomainService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;

import java.util.List;

@DomainService
public class FindSameQuestion {

    MongoTemplate mongoTemplate;

    FindSameQuestion(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<QuestionTextSerach> findQuestion(String questionText) {
        TextCriteria textCriteria = TextCriteria.forDefaultLanguage();
        textCriteria.matchingPhrase(questionText);

        Query query = TextQuery.queryText(textCriteria)
                .includeScore().sortByScore().with(PageRequest.of(0, 5));

        return mongoTemplate.find(query, QuestionTextSerach.class, "mcq");
    }
}
