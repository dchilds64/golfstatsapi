package com.golfstats.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
public class CourseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Integer id;
    private final String name;
}
