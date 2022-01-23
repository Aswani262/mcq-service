package com.tms.organisation.persistence.adaptors;

import com.tms.organisation.domain.Organisation;

public interface OrganisationRepository {
    void store(Organisation organisation);
    void searchForOrgName(String orgName);
}
