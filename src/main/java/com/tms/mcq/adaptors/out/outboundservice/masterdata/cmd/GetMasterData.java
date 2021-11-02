package com.tms.mcq.adaptors.out.outboundservice.masterdata.cmd;

import com.tms.mcq.application.ports.in.commands.MCQCommand;
import lombok.Data;

@Data
public class GetMasterData extends MCQCommand {
    private String subjectCode;
    private String topicCode;
    private String labelCode;
}
