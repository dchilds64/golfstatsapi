package com.golfstats.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.golfstats.model.RoundModel;
import com.golfstats.model.ShotModel;
import com.golfstats.service.RoundStatsService;

@RestController
@RequestMapping("/rounds")
public class RoundsController {

	private final RoundStatsService roundStatsService;

	@Autowired
	public RoundsController(RoundStatsService roundStatsService) {
		this.roundStatsService = roundStatsService;
	}

	@GetMapping("/{roundId}")
	public ResponseEntity<RoundModel> getRound(@PathVariable Long roundId) {
		try {
			return ResponseEntity.ok(roundStatsService.getRound(roundId));
		} catch (NotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public ResponseEntity<Integer> addRound(@RequestBody RoundModel round) {
		return ResponseEntity.ok(roundStatsService.addRound(round));
	}

	@PostMapping("/{roundId}/shots")
	public ResponseEntity<Integer> addShot(@PathVariable int roundId, @RequestBody ShotModel shot) {
		return ResponseEntity.ok(roundStatsService.addShot(shot));
	}

}
