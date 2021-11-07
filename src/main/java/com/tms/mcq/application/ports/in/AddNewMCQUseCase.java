package com.tms.mcq.application.ports.in;

import com.tms.mcq.application.ports.in.commands.AddNewMCQCmd;
import com.tms.mcq.framework.dto.ServiceResult;

import java.util.List;

public interface AddNewMCQUseCase {
    public ServiceResult addNewMCQ(AddNewMCQCmd cmd);

    public List<String> validate(AddNewMCQCmd cmd);
}
