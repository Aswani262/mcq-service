package com.tms.mcq.application.ports.in;

import com.tms.mcq.application.ports.in.commands.InitNewMCQCmd;
import com.tms.mcq.framework.dto.ServiceResult;

import java.util.Map;

public interface InitNewQuestionCreationUseCase {
    //We have to identied service result and use case result data and service
    // at present my thinking is like use is full fill by some service. so it ok to return service result
    // but if you think in another way , we can do something like this
    // A use case implementation service ( XXXXUseCaseImpl )which return UseCase result because that one only serve the
    // purpose to provide implementation of use case. and other service which provide their service to XXXUseCaseImpl will
    // return Service result. I will decide later , which one is better.
    // XXXUseCase can be seen as application service - the entry point in application
    ServiceResult init(InitNewMCQCmd cmd);
}
