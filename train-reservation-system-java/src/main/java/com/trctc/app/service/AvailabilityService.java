package com.trctc.app.service;

import com.trctc.app.model.AvailabilityMap;
import com.trctc.app.model.Route;
import com.trctc.app.model.Routes;
import com.trctc.app.repository.AvailabilityMapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class AvailabilityService {

    @Autowired
    StationService stationService;

    @Autowired
    AvailabilityMapRepository availabilityMapRepository;


    public boolean decreaseAvailability(int trainId,String date,String sourceStation,String destinationStation,int number){
        List<AvailabilityMap> list = availabilityMapRepository.findByTrainIdAndDate(trainId,date);
        if(list.size()>0){
            Map<String, Routes> map = list.get(0).getMap();
//            int routesId = map.get(date).getId();
            Routes routes = map.get(date);
            List<Route> routeList = routes.getRouteList();
            List<String> possibleRoutes = getPossibleRoutes(sourceStation, destinationStation, stationService.getAllStationNamesByTrainNumber(trainId));
            for (Route route:
                 routeList) {
                if(possibleRoutes.contains(route.getRoute_name())){
                    int seats = route.getSeats();
                    route.setSeats(seats-number);
                }
            }
            routes.setRouteList(routeList);
            map.put(date,routes);
            list.get(0).setMap(map);
            availabilityMapRepository.save(list.get(0));
//            for (Route route:
//                 routeList) {
//                System.out.println(route.toString());
//            }
//            map.get(date).getRouteList().forEach((route) -> {
//                if(route.getRoute_name().equals(sourceStation+" "+destinationStation)){
//                    route.setSeats(route.getSeats()-number);
//                }
//            });
//            Routes routes = new Routes();
//            routes.setDate(date);
////            List<Route> routeList1 = routes.getRouteList();
//            for (Route route:
//                 routeList) {
//                routes.getRouteList().add(new Route(route.getRoute_name(),route.getSeats()));
//            }
////            routes.setRouteList(routeList);
//////            routes.setId(routesId);
//            map.put(date,routes);
//            AvailabilityMap availabilityMap = new AvailabilityMap();
//            availabilityMap.setDate(date);
//            for (Map.Entry<String, Routes>map1:
//                 map.entrySet()) {
//                availabilityMap.getMap().put(map1.getKey(),map1.getValue());
//            }
////            availabilityMap.setMap(map);
//            availabilityMap.setTrainId(trainId);
//            availabilityMapRepository.save(availabilityMap);
        }else{
            System.out.println("Method decrease Availability: No train found");
        }
        return false;
    }
    public boolean increaseAvailability(int trainId,String date,String sourceStation,String destinationStation,int number){
        List<AvailabilityMap> list = availabilityMapRepository.findByTrainIdAndDate(trainId,date);
        if(list.size()>0){
            Map<String, Routes> map = list.get(0).getMap();
//            int routesId = map.get(date).getId();
            Routes routes = map.get(date);
            List<Route> routeList = routes.getRouteList();
            List<String> possibleRoutes = getPossibleRoutes(sourceStation, destinationStation, stationService.getAllStationNamesByTrainNumber(trainId));
            for (Route route:
                    routeList) {
                if(possibleRoutes.contains(route.getRoute_name())){
                    int seats = route.getSeats();
                    route.setSeats(seats+number);
                }
            }
            routes.setRouteList(routeList);
            map.put(date,routes);
            list.get(0).setMap(map);
            availabilityMapRepository.save(list.get(0));
        }else{
            System.out.println("Method increaseAvailability: No train found");
        }
        return false;
    }
    public int checkAvailability(int trainId,String date,String sourceStation,String destinationStation,List<String> stations,int noOfSeats){
        int min = Integer.MAX_VALUE;
        List<AvailabilityMap> list = availabilityMapRepository.findByTrainIdAndDate(trainId,date);
        if(list.size()>0){
            Map<String, Routes> map = list.get(list.size()-1).getMap();
            List<Route> routes = map.get(date).getRouteList();
            List<String> possibleroutes = getPossibleRoutes(sourceStation,destinationStation,stations);

            for (Route route:
                    routes) {
                if(possibleroutes.contains(route.getRoute_name())){
                    if(route.getSeats()<min){
                        min=route.getSeats();
                    }
                }
            }
        }else{
            addTrainToDB(trainId,date,stations,noOfSeats);
            min=noOfSeats;
        }
        if(min==Integer.MAX_VALUE){
            System.out.println("Method checkAvailability: -1");
            return -1;
        }
        return min;
    }
    private void addTrainToDB(int trainId, String date, List<String> stations, int noOfSeats) {
        List<Route> routeList = new ArrayList<>();
        for (int i = 1; i < stations.size(); i++) {
            routeList.add(new Route(stations.get(i-1)+" "+stations.get(i),noOfSeats));
        }
        Routes routes = new Routes();
        routes.setRouteList(routeList);
        routes.setDate(date);
        AvailabilityMap testMap = new AvailabilityMap();
        testMap.setTrainId(trainId);
        testMap.getMap().put(date,routes);
        testMap.setDate(date);
        availabilityMapRepository.save(testMap);
    }
    private List<String> getPossibleRoutes(String sourceStation, String destinationStation, List<String> stations) {
        List<String> possibleRoutes = new ArrayList<>();
        int start =-1;
        for (int i = 0; i < stations.size(); i++) {
            if(stations.get(i).equals(sourceStation)){
                start=i;
                break;
            }
        }
        if(start==-1){
            System.out.println("Method name getPossibleRoutes: no source station found");
        }else{
            for (int i = start+1; i < stations.size(); i++) {
                if(!stations.get(i).equals(destinationStation)){
                    possibleRoutes.add(stations.get(i-1)+" "+stations.get(i));
                }else{
                    possibleRoutes.add(stations.get(i-1)+" "+destinationStation);
                    break;
                }
            }
        }
        return possibleRoutes;
    }


}
