package com.trctc.app.controller;

import com.trctc.app.model.Gender;
import com.trctc.app.model.Passenger;
import com.trctc.app.model.Train;
import com.trctc.app.model.forms.TrainForm;
import com.trctc.app.repository.TrainRepository;
import com.trctc.app.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    TrainService trainService;

    @PostMapping("/trains")
    public ResponseEntity<String> addTrain(@RequestBody TrainForm trainForm){
        trainService.addTrain(trainForm);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/trains/{trainNumber}")
    public ResponseEntity<String> deleteTrain(@PathVariable int trainNumber){
        boolean b = trainService.deleteTrainByTrainNumber(trainNumber);
        if(b){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }




}
