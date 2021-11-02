package com.tms.mcq.application.ports.in.commands;

import com.tms.mcq.framework.exception.*;
import com.tms.mcq.framework.utils.MessageCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@NoArgsConstructor
public class InitNewMCQCmd extends MCQCommand{
    private String orgCode;
    private String subjectId;

    /**
     * Factory method to build InitNewMCQCmd from request
     * its also do the structural validation of command
     * @param req
     * @return
     */
    public static InitNewMCQCmd from(Map<String, Object> req) {
        InitNewMCQCmd cmd = new InitNewMCQCmd();
        cmd.orgCode = (String)req.get("orgCode");
        cmd.subjectId =(String)req.get("subjectId");
        return cmd;
    }
}
