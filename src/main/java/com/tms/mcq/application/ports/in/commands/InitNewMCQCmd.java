package com.tms.mcq.application.ports.in.commands;

import com.tms.mcq.framework.exception.*;
import lombok.AllArgsConstructor;
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
        List<MessageCode> error = cmd.validate();
        if(!cmd.validate().isEmpty()){
            throw new TMSException(ErrorCode.ER_10001,error,ErrorType.ILLEGAL_ARGUMENT,false);
        }
        return cmd;
    }

    public List<MessageCode> validate() {
        List<MessageCode> errors = new ArrayList<>();
        if(StringUtils.isBlank(this.orgCode)){
            errors.add(MessageCode.MS_10001);
        }
        if(StringUtils.isBlank(this.subjectId)){
            errors.add(MessageCode.MS_10002);
        }
        return errors;
    }
}
