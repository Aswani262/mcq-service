package com.tms.organisation.domainservcies;

import com.tms.framework.annotation.DomainService;
import com.tms.organisation.persistence.adaptors.OrganisationRepository;

@DomainService
public class CheckForDuplicationOrganisationKey {

    private final OrganisationRepository organisationRepository;

    public CheckForDuplicationOrganisationKey(OrganisationRepository organisationRepository){
        this.organisationRepository = organisationRepository;
    }

    public boolean isDuplicateOrgName(String orgCode) {
        organisationRepository.searchForOrgName(orgCode);
        return true;
    }
}
