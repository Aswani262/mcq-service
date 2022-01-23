package com.tms.organisation.persistence.adaptors;

import com.tms.organisation.domain.Organisation;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrganisationRepositoryImpl implements OrganisationRepository {

    private final MongoTemplate mongoTemplate;

    public OrganisationRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void store(Organisation organisation) {
        mongoTemplate.save(organisation);
    }

    @Override
    public void searchForOrgName(String orgName) {

    }
}
