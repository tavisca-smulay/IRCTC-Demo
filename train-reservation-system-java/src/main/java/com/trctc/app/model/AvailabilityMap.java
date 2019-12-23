package com.trctc.app.model;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class AvailabilityMap {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

//    @OneToMany(mappedBy = "testMap", cascade = CascadeType.ALL,targetEntity = Routes.class)
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,targetEntity = Routes.class)
    @MapKey(name = "date")
    private Map<String,Routes> map;

    @Column(name = "trainId")
    private Integer trainId;

    @Column(name = "date")
    private String date;

    public AvailabilityMap() {
        this.map =new HashMap<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Map<String, Routes> getMap() {
        return map;
    }

    public void setMap(Map<String, Routes> map) {
        this.map = map;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getTrainId() {
        return trainId;
    }

    public void setTrainId(Integer trainId) {
        this.trainId = trainId;
    }

    @Override
    public String toString() {
        return "TestMap{" +
                "id=" + id +
                ", map=" + map +
                ", date='" + date + '\'' +
                '}';
    }
}
