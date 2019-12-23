package com.trctc.app.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Routes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

//    @ManyToOne(cascade = CascadeType.ALL,targetEntity = TestMap.class)
//    private TestMap testMap;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,targetEntity = Route.class)
    private List<Route> routeList;

    @Column(name = "date")
    private String date;

    public Routes() {
        routeList = new ArrayList<>();    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public TestMap getTestMap() {
//        return testMap;
//    }
//
//    public void setTestMap(TestMap testMap) {
//        this.testMap = testMap;
//    }

    public List<Route> getRouteList() {
        return routeList;
    }

    public void setRouteList(List<Route> routeList) {
        this.routeList = routeList;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Routes{" +
                "id=" + id +
                ", routeList=" + routeList +
                ", date='" + date + '\'' +
                '}';
    }
}
