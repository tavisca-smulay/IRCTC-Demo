package com.trctc.app.controller;

import com.trctc.app.model.Train;
import com.trctc.app.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    SearchService searchService;

    @GetMapping("/source/{source}/dest/{dest}")
    public ResponseEntity<List<Train>> getTrains(@PathVariable String source,@PathVariable String dest) {
        List<Train> trainList = searchService.getTrainBetweenStations(source, dest);
        if(trainList.size()==0){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(trainList, HttpStatus.OK);
    }
}
