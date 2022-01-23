package com.tms.organisation.usecase;

import com.tms.framework.commandhandling.Command;
import com.tms.framework.dto.ServiceResult;
import com.tms.organisation.exception.OrganisationErrorCode;
import com.tms.organisation.exception.OrganisationException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

public interface RegisterNewOrganisationUseCase {



    ServiceResult registerNewOrganisation(RegisterNewOrganisation cmd);


    @Getter
    @NoArgsConstructor
    public static class RegisterNewOrganisation extends Command {
        private String name;
        private String orgKey;
        public void validate(){
            if(StringUtils.isBlank(this.name)){
                throw new OrganisationException(OrganisationErrorCode.ORG_104,"Name is mandatory");
            }
        }
    }

    static RegisterNewOrganisation from(String name , String orgKey) {
        RegisterNewOrganisation cmd = new RegisterNewOrganisation();
        cmd.name = name;
        cmd.orgKey = orgKey;
        return cmd;
    }
}
