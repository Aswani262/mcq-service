package com.tms.mcq.adaptors.out.persistence.repo;

import com.tms.mcq.application.ports.out.SequenceService;
import org.springframework.stereotype.Service;

@Service
public class SequenceServiceImpl implements SequenceService {
    @Override
    public String getNextSequence(String entityName) {
        return null;
    }
}
