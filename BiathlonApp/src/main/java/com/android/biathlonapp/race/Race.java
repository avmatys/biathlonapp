package com.android.biathlonapp.race;

import java.util.Date;
import java.util.Objects;

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

    public Date getDate() {
        return date;
    }

    public double getDistance() {
        return distance;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Race)) return false;
        Race race = (Race) o;
        return Double.compare(race.getDistance(), getDistance()) == 0 &&
                Objects.equals(getDate(), race.getDate()) &&
                Objects.equals(getDescription(), race.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDate(), getDistance(), getDescription());
    }
}
