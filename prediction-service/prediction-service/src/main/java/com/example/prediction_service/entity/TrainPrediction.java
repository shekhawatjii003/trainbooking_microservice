package com.example.prediction_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrainPrediction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long trainId;
    @Column(nullable = false)
    private Long currentStationId;
    @Column(nullable = false)
    private Long nextStationId;
    @Column(nullable = false)
    private LocalDate predictionDate;
    @Column(nullable = false)
    private LocalDateTime predictedArrivalTime;
    @Column(nullable = false)
    private Integer predictedDelayMinutes;
    @Column(nullable = false)
    private Double delayProbability;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PredictionStatus status;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime updatedAt;
}
