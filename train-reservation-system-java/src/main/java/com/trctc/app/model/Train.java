package com.trctc.app.model;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int trainId;
    int trainNumber;
    String trainName;
    int numberOfSeats;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "train_station",
            joinColumns = @JoinColumn(name = "train_id", referencedColumnName = "trainId"),
            inverseJoinColumns = @JoinColumn(name = "station_id", referencedColumnName = "id"))
    private List<Station> stationList;

    @ElementCollection
    private List<String> stationTimeList;

    public Train() {
    }

    public Train(int trainId, int trainNumber, String trainName, int numberOfSeats, List<String> stationTimeList,Station... stations) {
        this.trainId = trainId;
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.numberOfSeats = numberOfSeats;
        this.stationTimeList = stationTimeList;

        this.stationList= Stream.of(stations).collect(Collectors.toList());
        this.stationList.forEach(x->{
            x.getTrains().add(this);
        });
    }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public List<Station> getStationList() {
        return stationList;
    }

    public void setStationList(List<Station> stationList) {
        this.stationList = stationList;
    }

    public List<String> getStationTimeList() {
        return stationTimeList;
    }

    public void setStationTimeList(List<String> stationTimeList) {
        this.stationTimeList = stationTimeList;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public String toString() {
        return "Train{" +
                "trainId=" + trainId +
                ", trainNumber=" + trainNumber +
                ", trainName='" + trainName + '\'' +
                ", numberOfSeats=" + numberOfSeats +
                ", stationList=" + stationList +
                ", stationTimeList=" + stationTimeList +
                '}';
    }
}