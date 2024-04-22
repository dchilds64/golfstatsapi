package com.golfstats.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.golfstats.model.RoundModel;
import com.golfstats.model.ShotModel;
import com.golfstats.repository.RoundsRepository;
import com.golfstats.repository.ShotsRepository;

@Service
public class RoundStatsService {
    
    private final RoundsRepository roundsRepository;
    private final ShotsRepository shotsRepository;

    @Autowired
    public RoundStatsService(RoundsRepository roundsRepository, ShotsRepository shotsRepository) {
        this.roundsRepository = roundsRepository;
        this.shotsRepository = shotsRepository;
    }

    public RoundModel getRound(Long roundId) throws NotFoundException {
        Optional<RoundModel> round = roundsRepository.findById(roundId);
        if (!round.isPresent()) {
            throw new NotFoundException();
        } else {
            return round.get();
        }
    }

    public Integer addRound(RoundModel round) {
        RoundModel savedRound = roundsRepository.save(round);
        return savedRound.getId();
    }

    public Integer addShot(ShotModel shot) {
        ShotModel savedShot = shotsRepository.save(shot);
        return savedShot.getId();
    }
}
