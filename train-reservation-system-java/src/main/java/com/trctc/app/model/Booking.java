package com.trctc.app.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;
    private int trainNumber;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private User user;

    private String sourceStation;
    private String destinationStation;

    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;

    @ElementCollection
    private Set<Passenger> passengers=new HashSet<>();

    public Booking() {
    }

    public Booking(int trainId, String sourceStation, String destinationStation, BookingStatus bookingStatus, Set<Passenger> passengers) {
        this.trainNumber = trainId;
        this.sourceStation = sourceStation;
        this.destinationStation = destinationStation;
        this.bookingStatus = bookingStatus;
        this.passengers = passengers;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSourceStation() {
        return sourceStation;
    }

    public void setSourceStation(String sourceStation) {
        this.sourceStation = sourceStation;
    }

    public String getDestinationStation() {
        return destinationStation;
    }

    public void setDestinationStation(String destinationStation) {
        this.destinationStation = destinationStation;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public Set<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(Set<Passenger> passengers) {
        this.passengers = passengers;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", trainId=" + trainNumber +
                ", user=" + user +
                ", sourceStation='" + sourceStation + '\'' +
                ", destinationStation='" + destinationStation + '\'' +
                ", bookingStatus=" + bookingStatus +
                ", passengers=" + passengers +
                '}';
    }
}
