package com.example.hotels;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Hotel extends RealmObject {
    @PrimaryKey
    private String id;
    private String name;
    private double nbStars;

    public Hotel(String id, String name, double nbStars) {
        this.id = id;
        this.name = name;
        this.nbStars = nbStars;
    }

    public Hotel(String id) {
    }

    public Hotel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getNbStars() {
        return nbStars;
    }

    public void setNbStars(double nbStars) {
        this.nbStars = nbStars;
    }
}
