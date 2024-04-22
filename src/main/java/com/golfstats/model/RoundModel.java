package com.golfstats.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "rounds")
public class RoundModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rounds_seq_generator")
    @SequenceGenerator(name = "rounds_seq_generator", sequenceName = "rounds_seq", allocationSize = 1)
    private final Integer id;
    @Column(name = "courseid")
    private final Integer courseId;
    private final String date;
    private final Integer temperature;
    private final Integer wind;
    private final String tees;

    public RoundModel() {
        this.id = null;
        this.courseId = null;
        this.date = null;
        this.temperature = null;
        this.wind = null;
        this.tees = null;
    }

    public RoundModel(Integer id, Integer courseId, String date, Integer temperature, Integer wind, String tees) {
        this.id = id;
        this.courseId = courseId;
        this.date = date;
        this.temperature = temperature;
        this.wind = wind;
        this.tees = tees;
    }
}
