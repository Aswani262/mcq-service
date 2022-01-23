package com.tms.organisation.domain;

import com.tms.shared.TypeRef;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OrganisationContactMech {
    private String contactMechId;
    private LocalDateTime fromDate;
    private LocalDateTime thruDate;
    private Set<TypeRef> contactMechTypeId;//Phone , Postal Address , Email
    private Set<TypeRef> contactMechPurposeTypeId; // Primary Billing Address , Primary Phone no , Secondary Phone no
}
