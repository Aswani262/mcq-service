package com.tms.mcq.application.ports.in.commands;

import lombok.Data;

@Data
public class Option {
    private String optionText;
    private String optionId;
    private boolean isAnswer;

}
