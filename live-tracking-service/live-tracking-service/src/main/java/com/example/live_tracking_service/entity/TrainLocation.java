package com.example.live_tracking_service.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "train_locations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrainLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long trainId;

    @Column(nullable = false)
    private Long currentStationId;

    private Long nextStationId;

    private Double latitude;

    private Double longitude;

    private Integer delayMinutes;

    private String platform;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TrackingStatus status;

    @Column(nullable = false)
    private LocalDateTime estimatedArrival;

    @Column(nullable = false)
    private LocalDateTime lastUpdated;
}