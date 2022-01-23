package com.tms.organisation.domain;

import com.tms.mcq.domain.AggregatesRoot;
import com.tms.shared.TypeRef;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Document
public class Organisation extends AggregatesRoot {
    private String orgId;//Random unique Id
    private String orgKey;//Defined by user - can be duplicate , but not duplicate same tenant
    private String name;
    private TypeRef orgTypeId; //Coaching,School,Institute,Collage
    private List<OrganisationContactMech> contactMeches;
    private LocalDateTime fromDate;
    private LocalDateTime toDate;
    private boolean isActive;

    public static Organisation newInstance(String orgName,String orgCode,TypeRef typeId) {
       Organisation organisation = new Organisation();
       organisation.orgId = UUID.fromString(orgName).toString();
       organisation.orgTypeId = typeId;
       organisation.fromDate = LocalDateTime.now();
       organisation.isActive = true;
       return organisation;
    }
}
