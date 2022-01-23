package com.tms.mcq.domain.mcq;


import com.tms.shared.UserRef;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Getter
@NoArgsConstructor
public class Approvarer {
    private UserRef userId;
    private String subject;
    private Set<String> topic;

}
