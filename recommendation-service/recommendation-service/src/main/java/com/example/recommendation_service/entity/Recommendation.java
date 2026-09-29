package com.example.recommendation_service.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "recommendations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Recommendation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long sourceStationId;

    @Column(nullable = false)
    private Long destinationStationId;

    @Column(nullable = false)
    private LocalDate journeyDate;

    @Column(nullable = false)
    private Long recommendedTrainId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RecommendationType recommendationType;

    @Column(nullable = false, length = 500)
    private String reason;

    @Column(nullable = false)
    private Double score;

    @Column(nullable = false)
    private LocalDateTime createdAt;
}