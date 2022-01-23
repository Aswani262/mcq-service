package com.tms.student.domain;

import com.tms.shared.ContactMechRef;
import com.tms.shared.UserRef;

import java.util.List;

public class Student {
    private UserRef studentId;
    private String name;
    private List<ContactMechRef> contactMecId;
}
