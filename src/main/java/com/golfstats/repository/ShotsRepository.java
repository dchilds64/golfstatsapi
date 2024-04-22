package com.golfstats.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.golfstats.model.ShotModel;

@Repository
public interface ShotsRepository extends CrudRepository<ShotModel, Long> {
    
}
