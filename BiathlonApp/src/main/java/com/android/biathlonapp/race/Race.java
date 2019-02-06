package com.android.biathlonapp.race;

import java.util.Date;

public class Race {

    private Date date;
    private double distance;
    private String description;

    public Race() {

    }

    public Race(Date date, double distance, String description) {
        this.date = date;
        this.distance = distance;
        this.description = description;
    }
}
