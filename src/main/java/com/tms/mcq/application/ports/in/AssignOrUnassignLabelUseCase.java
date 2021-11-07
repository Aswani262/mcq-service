package com.tms.mcq.application.ports.in;


import com.tms.mcq.application.ports.in.commands.AssignLabel;
import com.tms.mcq.framework.dto.ServiceResult;

public interface AssignOrUnassignLabelUseCase {

    public ServiceResult assignLabel(AssignLabel cmd);
}
