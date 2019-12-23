package com.trctc.app.service;

import com.trctc.app.model.Train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {

    @Autowired
    StationService stationService;

    public List<Train> getTrainBetweenStations(String source,String destination){

        List<Train> commonTrains = getCommonTrainsBetweenStations(source,destination);


        List<Train> result = new ArrayList<>();

        for (Train train:
             commonTrains) {
            for (int i = 0; i < train.getStationList().size(); i++) {
                if(train.getStationList().get(i).getName().equals(source)){
                    result.add(train);
                    break;
                }else if(train.getStationList().get(i).getName().equals(destination)){
                    break;
                }
            }
        }

        return result;
    }

    private List<Train> getCommonTrainsBetweenStations(String source, String destination) {

        List<Train> trainsInSource = new ArrayList<>();
        if(!stationService.getStationByName(source).isPresent()){
            return new ArrayList<>();
        }

        trainsInSource=stationService.getTrainsInStation(source);

//        System.out.println("==========");
//        for (Train tr :
//                trainsInSource) {
//            System.out.println(tr.getTrainNumber());
//        }

        List<Train> trainsInDesc=new ArrayList<>();
        if(!stationService.getStationByName(destination).isPresent()){
            return new ArrayList<>();
        }
        trainsInDesc=stationService.getTrainsInStation(destination);

//        System.out.println("==========");
//        for (Train tr :
//                trainsInDesc) {
//            System.out.println(tr.getTrainNumber());
//        }

        List<Train> commonTrains=new ArrayList<>();

        for (int i = 0; i <trainsInSource.size() ; i++) {

            for(int j=0;j<trainsInDesc.size();j++){
                if(trainsInSource.get(i).getTrainNumber()==trainsInDesc.get(j).getTrainNumber()){
                    commonTrains.add(trainsInDesc.get(j));
                }
            }

        }

        return commonTrains;
    }
}
