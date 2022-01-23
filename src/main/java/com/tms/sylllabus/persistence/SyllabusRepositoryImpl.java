package com.tms.sylllabus.persistence;

import com.tms.sylllabus.domain.Syllabus;
import org.springframework.stereotype.Repository;

@Repository
public class SyllabusRepositoryImpl implements SyllabusRepository{
    @Override
    public void store(Syllabus syllabus) {

    }

    @Override
    public Syllabus findById(String syllabusId) {
        return null;
    }
}
