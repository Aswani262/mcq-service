package com.tms.organisation.restapi.req;

import lombok.Data;

@Data
public class RegisterOrganisationReq {
    private String name;
    private String orgKey;

}
