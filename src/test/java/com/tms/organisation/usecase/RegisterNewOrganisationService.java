package com.tms.organisation.usecase;

import com.tms.framework.annotation.UseCaseService;
import com.tms.framework.dto.ServiceResult;
import com.tms.organisation.domain.Organisation;
import com.tms.organisation.domainservcies.CheckForDuplicationOrganisationKey;
import com.tms.organisation.persistence.adaptors.OrganisationRepository;
import com.tms.shared.TypeRef;

@UseCaseService
public class RegisterNewOrganisationService implements RegisterNewOrganisationUseCase{

        private final CheckForDuplicationOrganisationKey checkForDuplicationOrganisationCode;
        private final OrganisationRepository organisationRepository;

        public RegisterNewOrganisationService(CheckForDuplicationOrganisationKey checkForDuplicationOrganisationName, OrganisationRepository organisationRepository) {
            this.checkForDuplicationOrganisationCode = checkForDuplicationOrganisationName;
            this.organisationRepository = organisationRepository;
        }

        @Override
        public ServiceResult registerNewOrganisation(RegisterNewOrganisation cmd) {
            ServiceResult serviceResult = new ServiceResult();
            checkForDuplicationOrganisationCode.isDuplicateOrgName(cmd.orgCode());
            Organisation organisation = Organisation.newInstance(cmd.getName(),cmd.getOrgKey(),new TypeRef("COACHING"));
            organisationRepository.store(organisation);
            return serviceResult;
        }
}

