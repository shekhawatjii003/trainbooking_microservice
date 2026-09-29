package com.example.schedule_service.controller;

import com.example.schedule_service.entity.TrainJourney;
import com.example.schedule_service.service.TrainJourneyService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/journeys")
public class TrainJourneyController {

    private final TrainJourneyService trainJourneyService;

    public TrainJourneyController(
            TrainJourneyService trainJourneyService
    ) {
        this.trainJourneyService = trainJourneyService;
    }

    @PostMapping
    public ResponseEntity<TrainJourney> createJourney(
            @RequestBody TrainJourney trainJourney
    ) {

        return ResponseEntity.ok(
                trainJourneyService.createJourney(trainJourney)
        );
    }

    @GetMapping
    public ResponseEntity<List<TrainJourney>> getAllJourneys() {

        return ResponseEntity.ok(
                trainJourneyService.getAllJourneys()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrainJourney> getJourneyById(
            @PathVariable Long id
    ) {

        return ResponseEntity.ok(
                trainJourneyService.getJourneyById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrainJourney> updateJourney(
            @PathVariable Long id,
            @RequestBody TrainJourney trainJourney
    ) {

        return ResponseEntity.ok(
                trainJourneyService.updateJourney(
                        id,
                        trainJourney
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TrainJourney> deleteJourney(
            @PathVariable Long id
    ) {

        return ResponseEntity.ok(
                trainJourneyService.deleteJourney(id)
        );
    }

    @GetMapping("/train/{trainId}")
    public ResponseEntity<List<TrainJourney>> getJourneysByTrain(
            @PathVariable Long trainId
    ) {

        return ResponseEntity.ok(
                trainJourneyService.getJourneysByTrain(trainId)
        );
    }

    @GetMapping("/train/{trainId}/date")
    public ResponseEntity<TrainJourney> getJourneyByTrainAndDate(
            @PathVariable Long trainId,
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate date
    ) {

        return ResponseEntity.ok(
                trainJourneyService.getJourneyByTrainAndDate(
                        trainId,
                        date
                )
        );
    }

    @GetMapping("/date")
    public ResponseEntity<List<TrainJourney>> getJourneysByDate(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate date
    ) {

        return ResponseEntity.ok(
                trainJourneyService.getJourneysByDate(date)
        );
    }

    @GetMapping("/active")
    public ResponseEntity<List<TrainJourney>> getActiveJourneys() {

        return ResponseEntity.ok(
                trainJourneyService.getActiveJourneys()
        );
    }

    @GetMapping("/train/{trainId}/active")
    public ResponseEntity<List<TrainJourney>> getActiveJourneysByTrain(
            @PathVariable Long trainId
    ) {

        return ResponseEntity.ok(
                trainJourneyService.getActiveJourneysByTrain(trainId)
        );
    }
}