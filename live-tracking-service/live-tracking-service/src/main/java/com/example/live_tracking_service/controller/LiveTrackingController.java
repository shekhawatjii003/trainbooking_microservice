package com.example.live_tracking_service.controller;

import com.example.live_tracking_service.entity.TrainLocation;
import com.example.live_tracking_service.entity.TrackingStatus;
import com.example.live_tracking_service.service.LiveTrackingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tracking")
public class LiveTrackingController {

    private final LiveTrackingService liveTrackingService;

    public LiveTrackingController(
            LiveTrackingService liveTrackingService) {

        this.liveTrackingService =
                liveTrackingService;
    }

    @PostMapping
    public TrainLocation createTracking(
            @RequestBody TrainLocation trainLocation) {

        return liveTrackingService
                .createTracking(trainLocation);
    }

    @GetMapping
    public List<TrainLocation> getAllTracking() {

        return liveTrackingService
                .getAllTracking();
    }

    @GetMapping("/{id}")
    public TrainLocation getTrackingById(
            @PathVariable Long id) {

        return liveTrackingService
                .getTrackingById(id);
    }

    @PutMapping("/{id}")
    public TrainLocation updateTracking(
            @PathVariable Long id,
            @RequestBody TrainLocation trainLocation) {

        return liveTrackingService
                .updateTracking(id, trainLocation);
    }

    @DeleteMapping("/{id}")
    public TrainLocation deleteTracking(
            @PathVariable Long id) {

        return liveTrackingService
                .deleteTracking(id);
    }

    @GetMapping("/train/{trainId}")
    public TrainLocation getTrackingByTrainId(
            @PathVariable Long trainId) {

        return liveTrackingService
                .getTrackingByTrainId(trainId);
    }

    @GetMapping("/station/current/{stationId}")
    public List<TrainLocation> getByCurrentStation(
            @PathVariable Long stationId) {

        return liveTrackingService
                .getTrackingByCurrentStation(stationId);
    }

    @GetMapping("/station/next/{stationId}")
    public List<TrainLocation> getByNextStation(
            @PathVariable Long stationId) {

        return liveTrackingService
                .getTrackingByNextStation(stationId);
    }

    @GetMapping("/status/{status}")
    public List<TrainLocation> getByStatus(
            @PathVariable TrackingStatus status) {

        return liveTrackingService
                .getTrackingByStatus(status);
    }
}