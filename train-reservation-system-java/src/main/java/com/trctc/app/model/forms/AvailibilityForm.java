package com.trctc.app.model.forms;

import java.util.List;

public class AvailibilityForm {
    int trainNumber;
    String source;
    String destination;
    String date;

    public AvailibilityForm(int trainNumber, String source, String destination, String date) {
        this.trainNumber = trainNumber;
        this.source = source;
        this.destination = destination;
        this.date = date;
    }

    public AvailibilityForm() {
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return "AvailibilityForm{" +
                "trainNumber=" + trainNumber +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
