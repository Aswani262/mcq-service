package com.tms.organisation.domainservcies;

import com.tms.framework.annotation.DomainService;
import com.tms.organisation.persistence.adaptors.OrganisationRepository;

@DomainService
public class GenerateUniqueOrganisationId {

    private final OrganisationRepository organisationRepository;

    public GenerateUniqueOrganisationId(OrganisationRepository organisationRepository) {
        this.organisationRepository = organisationRepository;
    }

}
