package com.trctc.app.service;

import com.trctc.app.model.Station;
import com.trctc.app.model.Train;
import com.trctc.app.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StationService {
    @Autowired
    private StationRepository stationRepository;

    @Autowired
    TrainService trainService;

    public List<Station> getAllStations() {
        return stationRepository.findAll();
    }

    public Optional<Station> getStation(int id) {
        return stationRepository.findById(id);
    }

    public List<Train> getTrainsInStation(String stationName){
        if(stationRepository.findByName(stationName).isPresent()){
            return stationRepository.findByName(stationName).get().getTrains();
        }else{
            System.out.println("station not found");
            return null;
        }
    }

    public Optional<Station> getStationByName(String name){
        return stationRepository.findByName(name);
    }



    public void addStation(Station station) {
        stationRepository.save(station);
    }

    public void updateStation(Station station) {
        stationRepository.save(station);
    }

    public void deleteStation(int id) {
        stationRepository.deleteById(id);
    }

    public List<String> getAllStationNames(){
        List<Station> stations=stationRepository.findAll();
        List<String> stationNames=new ArrayList<>();
        for (Station station :
                stations) {
            stationNames.add(station.getName());
        }
        return stationNames;
    }

    public List<String> getAllStationNamesByTrainNumber(int trainNumber){
        List<Station> stations=trainService.getTrainByTrainNumber(trainNumber).get().getStationList();
        List<String> stationNames=new ArrayList<>();
        for (Station station :
                stations) {
            stationNames.add(station.getName());
        }
        return stationNames;

    }

}
