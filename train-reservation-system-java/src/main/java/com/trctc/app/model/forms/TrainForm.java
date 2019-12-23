package com.trctc.app.model.forms;

import java.util.List;

public class TrainForm {
    int trainNumber;
    String trainName;
    List<String> stationList;
    List<String> timeList;
    int numberOfSeats;

    public TrainForm() {
    }

    public TrainForm(int trainNumber, String trainName, List<String> stationList, List<String> time, int numberOfSeats) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.stationList = stationList;
        this.timeList = time;
        this.numberOfSeats = numberOfSeats;
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

    public List<String> getStationList() {
        return stationList;
    }

    public void setStationList(List<String> stationList) {
        this.stationList = stationList;
    }

    public List<String> getTimeList() {
        return timeList;
    }

    public void setTimeList(List<String> timeList) {
        this.timeList = timeList;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }


    @Override
    public String toString() {
        return "TrainForm{" +
                "trainNumber=" + trainNumber +
                ", trainName='" + trainName + '\'' +
                ", stationList=" + stationList +
                ", timeList=" + timeList +
                ", numberOfSeats=" + numberOfSeats +
                '}';
    }
}

