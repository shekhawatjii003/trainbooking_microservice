package com.example.recommendation_service.controller;

import com.example.recommendation_service.entity.Recommendation;
import com.example.recommendation_service.entity.RecommendationType;
import com.example.recommendation_service.service.RecommendationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {

    private final RecommendationService recommendationService;

    public RecommendationController(
            RecommendationService recommendationService) {

        this.recommendationService = recommendationService;
    }

    @PostMapping
    public ResponseEntity<Recommendation> createRecommendation(
            @Valid @RequestBody Recommendation recommendation) {

        return new ResponseEntity<>(
                recommendationService.createRecommendation(
                        recommendation
                ),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<List<Recommendation>>
    getAllRecommendations() {

        return ResponseEntity.ok(
                recommendationService.getAllRecommendations()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recommendation>
    getRecommendationById(@PathVariable Long id) {

        return ResponseEntity.ok(
                recommendationService
                        .getRecommendationById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recommendation>
    updateRecommendation(
            @PathVariable Long id,
            @RequestBody Recommendation recommendation) {

        return ResponseEntity.ok(
                recommendationService
                        .updateRecommendation(
                                id,
                                recommendation
                        )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Recommendation>
    deleteRecommendation(@PathVariable Long id) {

        return ResponseEntity.ok(
                recommendationService
                        .deleteRecommendation(id)
        );
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Recommendation>>
    getRecommendationsByUser(
            @PathVariable Long userId) {

        return ResponseEntity.ok(
                recommendationService
                        .getRecommendationsByUser(userId)
        );
    }

    @GetMapping("/train/{trainId}")
    public ResponseEntity<List<Recommendation>>
    getRecommendationsByTrain(
            @PathVariable Long trainId) {

        return ResponseEntity.ok(
                recommendationService
                        .getRecommendationsByTrain(trainId)
        );
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<Recommendation>>
    getRecommendationsByType(
            @PathVariable RecommendationType type) {

        return ResponseEntity.ok(
                recommendationService
                        .getRecommendationsByType(type)
        );
    }

    @GetMapping("/user/{userId}/recent")
    public ResponseEntity<List<Recommendation>>
    getRecentRecommendations(
            @PathVariable Long userId) {

        return ResponseEntity.ok(
                recommendationService
                        .getRecentRecommendations(userId)
        );
    }
}