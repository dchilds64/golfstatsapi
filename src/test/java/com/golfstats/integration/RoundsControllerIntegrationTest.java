package com.golfstats.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.golfstats.model.RoundModel;
import com.golfstats.model.ShotModel;
import com.golfstats.repository.RoundsRepository;
import com.golfstats.repository.ShotsRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class RoundsControllerIntegrationTest {
    @Autowired
    private MockMvc mvc;

    @Autowired 
    private RoundsRepository roundsRepository;

    @Autowired
    private ShotsRepository shotsRepository;

    private final int roundId = 1;
    private final int courseId = 1;
    private final String date = "1/1/2024";
    private final String tees = "Test Tees";
    private final int temperature = 50;
    private final int wind = 1;

    private final Integer shotId = 1;
    private final String aboveBelow = "below";
    private final String club = "9i";
    private final Integer distance = 100;
    private final Boolean goingForGreen = true;
    private final String horizStrikeLoc = "toe";
    private final String lie = "uphill";
    private final Boolean made = false;
    private final String notes = "Test note.";
    private final Integer num = 1;
    private final Boolean penalty = false;
    private final String plan = "Test plan.";
    private final String intendedShape = "pull_fade";
    private final String shape = "pull";
    private final String uphillDownhill = "uphill";
    private final String vertStrikeLoc = "fat";
    private final Integer direction = 7;
    private final String result = "made";
    private final String type = "long";

    private final ShotModel shot = ShotModel.builder()
                                                .id(shotId)
                                                .roundId(roundId)
                                                .aboveBelow(aboveBelow)
                                                .club(club)
                                                .distance(distance)
                                                .goingForGreen(goingForGreen)
                                                .horizStrikeLoc(horizStrikeLoc)
                                                .lie(lie)
                                                .made(made)
                                                .notes(notes)
                                                .num(num)
                                                .penalty(penalty)
                                                .plan(plan)
                                                .intendedShape(intendedShape)
                                                .shape(shape)
                                                .uphillDownhill(uphillDownhill)
                                                .vertStrikeLoc(vertStrikeLoc)
                                                .direction(direction)
                                                .result(result)
                                                .type(type)
                                                .build();

    private final RoundModel round = RoundModel.builder()
                                                .id(roundId)
                                                .courseId(courseId)
                                                .date(date)
                                                .tees(tees)
                                                .temperature(temperature)
                                                .wind(wind)
                                                .build();

    @Test
    public void givenRound_whenAddRound_thenStatus200() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(round);
        mvc.perform(MockMvcRequestBuilders.post("/rounds").content(jsonString).contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andDo(result -> {
            assertTrue(result.getResponse().getContentAsString().equals("1"));
        });

        RoundModel dbRound = roundsRepository.findById(Long.valueOf(roundId)).orElse(new RoundModel());
        assertTrue(dbRound.equals(round));
    }

    @Test
    public void givenShot_whenAddShot_thenStatus200() throws Exception {
        roundsRepository.save(round);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(shot);
        mvc.perform(MockMvcRequestBuilders.post("/rounds/1/shots").content(jsonString).contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andDo(result -> {
            assertTrue(result.getResponse().getContentAsString().equals("1"));
        });

        ShotModel dbShot = shotsRepository.findById(Long.valueOf(shotId)).orElse(new ShotModel());
        assertTrue(dbShot.equals(shot));
    }

    @Test
    public void givenRoundIdThatExists_whenGetRound_thenStatus200() throws Exception {
        roundsRepository.save(round);
        mvc.perform(MockMvcRequestBuilders.get("/rounds/1"))
        .andExpect(status().isOk())
        .andDo(result -> {
            RoundModel savedRound = new ObjectMapper().readValue(result.getResponse().getContentAsString(), RoundModel.class);
            assertTrue(savedRound.equals(round));
        });
    }

    @Test
    public void givenRoundIdThatDoesNotExist_whenGetRound_thenStatus400() throws Exception {
        roundsRepository.save(round);
        mvc.perform(MockMvcRequestBuilders.get("/rounds/2"))
        .andExpect(status().isNotFound());
    }
}
