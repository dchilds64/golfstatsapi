package com.golfstats.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.golfstats.model.RoundModel;

@Repository
public interface RoundsRepository extends CrudRepository<RoundModel, Long> {

}
