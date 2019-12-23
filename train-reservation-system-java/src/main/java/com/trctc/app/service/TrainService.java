package com.trctc.app.service;

import com.trctc.app.model.Station;
import com.trctc.app.model.Train;
import com.trctc.app.model.forms.TrainForm;
import com.trctc.app.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TrainService {
    @Autowired
    private TrainRepository trainRepository;

    @Autowired
    private StationService stationService;

    public List<Train> getAllTrains () {
        List<Train> trains = new ArrayList<>();
        trainRepository.findAll();
        return trains;
    }

    public Optional<Train> getTrain (int trainId) {
        return trainRepository.findById(trainId);
    }

    public void addTrain (TrainForm trainForm) {

        List<Station> stationList=new ArrayList<>();

        for (String stationName :trainForm.getStationList()) {
            if(stationService.getStationByName(stationName).isPresent()){
                System.out.println(stationService.getStationByName(stationName).isPresent());
                stationList.add(stationService.getStationByName(stationName).get());
            }
            else{
                Station station=new Station(stationName);
                stationService.addStation(station);
                stationList.add(stationService.getStationByName(stationName).get());
            }
        }


        Train train=new Train(trainForm.getTrainNumber(),
                trainForm.getTrainNumber(),
                trainForm.getTrainName(),
                trainForm.getNumberOfSeats(),
                trainForm.getTimeList(),
                stationList.toArray(new Station[stationList.size()]));

        trainRepository.save(train);
    }

    public void updateTrain (Train train) {
        trainRepository.save(train);
    }

    public void deleteTrain (int trainId) {
        trainRepository.deleteById(trainId);
    }


    public Optional<Train> getTrainByTrainNumber(int trainNumber){
        return trainRepository.getTrainByTrainNumber(trainNumber);
    }

    public boolean deleteTrainByTrainNumber(int trainNumber){
        if(trainRepository.getTrainByTrainNumber(trainNumber).isPresent()){
            int i=trainRepository.deleteByTrainNumber(trainNumber);
            return true;
        }
        else
            return false;
    }

    public List<Train> getTrainsBetweenStations (int sourceId, int destId, String date) {
        List<Train> trains = new ArrayList<>();

        return trains;
    }


}
