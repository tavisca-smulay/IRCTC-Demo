package com.trctc.app.model;

import javax.persistence.*;

@Entity
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int route_id;
    private String route_name;
    private int seats;

    public Route() {
    }

    public Route(String route_name, int seats) {
        this.route_name = route_name;
        this.seats = seats;
    }

    public int getRoute_id() {
        return route_id;
    }

    public void setRoute_id(int route_id) {
        this.route_id = route_id;
    }

    public String getRoute_name() {
        return route_name;
    }

    public void setRoute_name(String route_name) {
        this.route_name = route_name;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "Route{" +
                "route_id=" + route_id +
                ", route_name='" + route_name + '\'' +
                ", seats=" + seats +
                '}';
    }
}
