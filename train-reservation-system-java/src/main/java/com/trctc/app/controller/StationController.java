package com.trctc.app.controller;

import com.trctc.app.model.Station;
import com.trctc.app.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class StationController {

    @Autowired
    private StationService stationService;

    @GetMapping("/stations")
    public List<Station> getAllStations () {
        return stationService.getAllStations();
    }

    @GetMapping("/stations/{id}")
    public Optional<Station> getStation (@PathVariable int id) {
        return stationService.getStation(id);
    }

    @PostMapping("/stations")
    public void addTrain (@RequestBody Station station) {
        stationService.addStation(station);
    }

    @PutMapping("/stations/{id}")
    public void updateTrain (@RequestBody Station station, @PathVariable int trainId) {
        stationService.updateStation(station);
    }

    @DeleteMapping("/stations/{id}")
    public void deleteTrain (@PathVariable int id) {
        stationService.deleteStation(id);
    }
}
