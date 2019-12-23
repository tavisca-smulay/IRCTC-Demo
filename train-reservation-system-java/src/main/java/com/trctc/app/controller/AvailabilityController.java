package com.trctc.app.controller;

import com.trctc.app.model.forms.AvailibilityForm;
import com.trctc.app.service.AvailabilityService;
import com.trctc.app.service.StationService;
import com.trctc.app.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class AvailabilityController {
    @Autowired
    AvailabilityService availabilityService;

    @Autowired
    StationService stationService;

    @Autowired
    TrainService trainService;

    @GetMapping("/seats")
    public ResponseEntity<Integer> getNumberOfAvailableSeats(@RequestBody AvailibilityForm availibilityForm){

        int result=availabilityService.checkAvailability(availibilityForm.getTrainNumber(),
                availibilityForm.getDate(),
                availibilityForm.getSource(),
                availibilityForm.getDestination(),
                stationService.getAllStationNamesByTrainNumber(availibilityForm.getTrainNumber()),
                trainService.getTrainByTrainNumber(availibilityForm.getTrainNumber()).get().getNumberOfSeats());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}
