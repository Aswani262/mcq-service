package com.tms.sylllabus.domain;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class SyllabusYear {
    private LocalDateTime fromYear;
    private LocalDateTime toYear;
}
