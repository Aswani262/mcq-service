package com.tms.organisation.restapi;

import com.tms.framework.commandhandling.Dispatcher;
import com.tms.framework.dto.ServiceResult;
import com.tms.organisation.restapi.req.RegisterOrganisationReq;
import com.tms.organisation.usecase.RegisterNewOrganisationUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/organisation")
public class OrganisationController {
    private final Dispatcher dispatcher;

    public OrganisationController(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    @PostMapping
    public CompletableFuture<ResponseEntity<ServiceResult>>registerOrganisation(@RequestBody  RegisterOrganisationReq req){
        RegisterNewOrganisationUseCase.RegisterNewOrganisation cmd = RegisterNewOrganisationUseCase.from(req.getName(),req.getOrgKey());
        CompletableFuture<ServiceResult> resultCmd = dispatcher.sendAndReceiveAsync(cmd);
        return resultCmd.thenApply(result -> new ResponseEntity<ServiceResult>(result, HttpStatus.ACCEPTED));
    }
}
