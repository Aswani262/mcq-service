package com.tms.mcq.infra.config;

import com.tms.mcq.adaptors.out.persistence.repo.MCQRepositoryImpl;
import com.tms.mcq.application.ports.in.AddNewMCQUseCase;
import com.tms.mcq.application.ports.out.MCQRepository;
import com.tms.mcq.application.services.AddNewMCQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class BeanConfiguration {

    @Bean("mcqRepository")
    @Autowired
    public MCQRepository mcqRepository(MongoTemplate template){
        MCQRepositoryImpl mcqRepository = new MCQRepositoryImpl(template);
        return mcqRepository;
    }

    @Bean("addNewMCQService")
    @Autowired
    public AddNewMCQUseCase addNewMCQUseCase(MCQRepository mcqRepository){
        AddNewMCQUseCase addNewMCQUseCase = new AddNewMCQService(mcqRepository);
        return  addNewMCQUseCase;
    }
}
