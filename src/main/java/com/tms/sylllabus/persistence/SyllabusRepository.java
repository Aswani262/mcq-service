package com.tms.sylllabus.persistence;

import com.tms.sylllabus.domain.Syllabus;

public interface SyllabusRepository {
    void store(Syllabus syllabus);

    Syllabus findById(String syllabusId);
}
