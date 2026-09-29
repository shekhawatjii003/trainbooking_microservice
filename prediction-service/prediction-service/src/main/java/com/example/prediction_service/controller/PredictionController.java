package com.example.prediction_service.controller;

import com.example.prediction_service.entity.PredictionStatus;
import com.example.prediction_service.entity.TrainPrediction;
import com.example.prediction_service.service.PredictionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/predictions")
public class PredictionController {

    private final PredictionService predictionService;

    public PredictionController(PredictionService predictionService) {
        this.predictionService = predictionService;
    }

    @PostMapping
    public ResponseEntity<TrainPrediction> createPrediction(
            @RequestBody TrainPrediction trainPrediction) {

        return ResponseEntity.ok(
                predictionService.createPrediction(trainPrediction)
        );
    }

    @GetMapping
    public ResponseEntity<List<TrainPrediction>> getAllPredictions() {

        return ResponseEntity.ok(
                predictionService.getAllPredictions()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrainPrediction> getPredictionById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                predictionService.getPredictionById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrainPrediction> updatePrediction(
            @PathVariable Long id,
            @RequestBody TrainPrediction trainPrediction) {

        return ResponseEntity.ok(
                predictionService.updatePrediction(id, trainPrediction)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TrainPrediction> deletePrediction(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                predictionService.deletePrediction(id)
        );
    }

    @GetMapping("/train/{trainId}")
    public ResponseEntity<TrainPrediction> getPredictionByTrain(
            @PathVariable Long trainId) {

        return ResponseEntity.ok(
                predictionService.getPredictionByTrain(trainId)
        );
    }

    @GetMapping("/station/current/{stationId}")
    public ResponseEntity<List<TrainPrediction>> getPredictionsByCurrentStation(
            @PathVariable Long stationId) {

        return ResponseEntity.ok(
                predictionService.getPredictionsByCurrentStation(stationId)
        );
    }

    @GetMapping("/station/next/{stationId}")
    public ResponseEntity<List<TrainPrediction>> getPredictionsByNextStation(
            @PathVariable Long stationId) {

        return ResponseEntity.ok(
                predictionService.getPredictionsByNextStation(stationId)
        );
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<TrainPrediction>> getPredictionsByDate(
            @PathVariable LocalDate date) {

        return ResponseEntity.ok(
                predictionService.getPredictionByDate(date)
        );
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<TrainPrediction>> getPredictionsByStatus(
            @PathVariable PredictionStatus status) {

        return ResponseEntity.ok(
                predictionService.getPredictionsByStatus(status)
        );
    }

    @PostMapping("/train/{trainId}/predict")
    public ResponseEntity<TrainPrediction> predictDelay(
            @PathVariable Long trainId) {

        return ResponseEntity.ok(
                predictionService.predictDelay(trainId)
        );
    }
}