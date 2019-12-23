package com.trctc.app.controller;

import com.trctc.app.model.Train;
import com.trctc.app.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TrainController {

    @Autowired
    private TrainService trainService;

    @GetMapping("/trains")
    public List<Train> getAllTrains () {
        return trainService.getAllTrains();
    }

    @GetMapping("/trains/{id}")
    public Optional<Train> getTrain (@PathVariable int trainId) {
        return trainService.getTrain (trainId);
    }


    @PutMapping("/trains/{id}")
    public void updateTrain (@RequestBody Train train, @PathVariable int trainId) {
        trainService.updateTrain(train);
    }

    @DeleteMapping("/trains/{id}")
    public void deleteTrain (@PathVariable int id) {
        trainService.deleteTrain(id);
    }
}
