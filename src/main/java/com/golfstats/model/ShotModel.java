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
@Table(name = "shots")
public class ShotModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shots_seq_generator")
    @SequenceGenerator(name = "shots_seq_generator", sequenceName = "shots_seq", allocationSize = 1)
    private final Integer id;
    @Column(name = "roundid")
    private final Integer roundId;
    @Column(name = "abovebelow")
    private final String aboveBelow;
    private final String club;
    private final Integer distance;
    @Column(name = "goingforgreen")
    private final Boolean goingForGreen;
    @Column(name = "horizstrikeloc")
    private final String horizStrikeLoc;
    private final String lie;
    private final Boolean made;
    private final String notes;
    private final Integer num;
    private final Boolean penalty;
    private final String plan;
    @Column(name = "intendedshape")
    private final String intendedShape;
    private final String shape;
    @Column(name = "uphilldownhill")
    private final String uphillDownhill;
    @Column(name = "vertstrikeloc")
    private final String vertStrikeLoc;
    private final Integer direction;
    private final String result;
    private final String type;

    public ShotModel() {
        this.id = null;
        this.roundId = null;
        this.aboveBelow = null;
        this.club = null;
        this.distance = null;
        this.goingForGreen = null;
        this.horizStrikeLoc = null;
        this.lie = null;
        this.made = null;
        this.notes = null;
        this.num = null;
        this.penalty = null;
        this.plan = null;
        this.intendedShape = null;
        this.shape = null;
        this.uphillDownhill = null;
        this.vertStrikeLoc = null;
        this.direction = null;
        this.result = null;
        this.type = null;
    }

    public ShotModel(
        Integer id, 
        Integer roundId, 
        String aboveBelow, 
        String club, 
        Integer distance, 
        Boolean goingForGreen, 
        String horizStrikeLoc, 
        String lie, 
        Boolean made,
        String notes,
        Integer num,
        Boolean penalty,
        String plan,
        String intendedShape,
        String shape,
        String uphillDownhill,
        String vertStrikeLoc,
        Integer direction,
        String result,
        String type) {
        this.id = id;
        this.roundId = roundId;
        this.aboveBelow = aboveBelow;
        this.club = club;
        this.distance = distance;
        this.goingForGreen = goingForGreen;
        this.horizStrikeLoc = horizStrikeLoc;
        this.lie = lie;
        this.made = made;
        this.notes = notes;
        this.num = num;
        this.penalty = penalty;
        this.plan = plan;
        this.intendedShape = intendedShape;
        this.shape = shape;
        this.uphillDownhill = uphillDownhill;
        this.vertStrikeLoc = vertStrikeLoc;
        this.direction = direction;
        this.result = result;
        this.type = type;
    }
}
