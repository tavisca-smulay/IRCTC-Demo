package com.trctc.app.model.forms;

import com.trctc.app.model.Passenger;

import java.util.List;
import java.util.Set;

public class BookingForm {
    int userId;
    int trainNumber;
    String source;
    String destination;
    String date;
    int numberOfSeats;
    Set<Passenger> passengerList;

    public BookingForm() {
    }

    public BookingForm(int userId, int trainNumber, int numberOfSeats, String source, String destination, String date, Set<Passenger> passengerList) {
        this.userId = userId;
        this.trainNumber = trainNumber;
        this.numberOfSeats = numberOfSeats;
        this.source = source;
        this.destination = destination;
        this.date = date;
        this.passengerList = passengerList;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
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

    public Set<Passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(Set<Passenger> passengerList) {
        this.passengerList = passengerList;
    }

    @Override
    public String toString() {
        return "BookingForm{" +
                "userId='" + userId + '\'' +
                ", trainNumber=" + trainNumber +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", date='" + date + '\'' +
                ", numberOfSeats=" + numberOfSeats +
                ", passengerList=" + passengerList +
                '}';
    }
}


