package com.tms.mcq.adaptors.out.outboundservice.masterdata.cmd;

import com.tms.mcq.application.ports.in.commands.MCQCommand;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetSubjectById extends MCQCommand {
    private String subjectId;


}
