package com.example.search_service.controller;

import com.example.search_service.entity.SearchHistory;
import com.example.search_service.service.SearchService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/search")
public class SearchController {

    private final SearchService searchService;

    public SearchController(
            SearchService searchService) {

        this.searchService = searchService;
    }

    @PostMapping
    public SearchHistory createSearch(
            @RequestBody SearchHistory searchHistory) {

        return searchService.createSearch(
                searchHistory
        );
    }

    @GetMapping
    public List<SearchHistory> getAllSearches() {

        return searchService.getAllSearches();
    }

    @GetMapping("/{id}")
    public SearchHistory getSearchById(
            @PathVariable Long id) {

        return searchService.getSearchById(id);
    }

    @GetMapping("/user/{userId}")
    public List<SearchHistory> getSearchesByUser(
            @PathVariable Long userId) {

        return searchService
                .getSearchesByUser(userId);
    }

    @GetMapping("/route")
    public List<SearchHistory> getSearchesByRoute(
            @RequestParam Long sourceStationId,
            @RequestParam Long destinationStationId) {

        return searchService.getSearchesByRoute(
                sourceStationId,
                destinationStationId
        );
    }

    @GetMapping("/date")
    public List<SearchHistory> getSearchesByDate(
            @RequestParam LocalDate travelDate) {

        return searchService
                .getSearchesByDate(travelDate);
    }

    @GetMapping("/user/{userId}/recent")
    public List<SearchHistory> getRecentSearches(
            @PathVariable Long userId) {

        return searchService
                .getRecentSearchesByUser(userId);
    }

    @DeleteMapping("/{id}")
    public String deleteSearch(
            @PathVariable Long id) {

        searchService.deleteSearch(id);

        return "Search deleted successfully";
    }
}