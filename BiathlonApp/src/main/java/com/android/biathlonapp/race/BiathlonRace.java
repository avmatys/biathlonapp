package com.android.biathlonapp.race;

import com.android.biathlonapp.race.value.GenderDescriptor;
import com.android.biathlonapp.race.value.RaceTypeDescriptor;

import java.util.Date;

public class BiathlonRace extends Race {

    @GenderDescriptor.Gender private String gender;
    @RaceTypeDescriptor.RaceType private String raceType;

    public BiathlonRace() {
    }

    public BiathlonRace(String gender, String raceType) {
        this.gender = gender;
        this.raceType = raceType;
    }

    public BiathlonRace(Date date, double distance, String description, String gender, String raceType) {
        super(date, distance, description);
        this.gender = gender;
        this.raceType = raceType;
    }

    public String getGender() {
        return gender;
    }

    public String getRaceType() {
        return raceType;
    }

}
