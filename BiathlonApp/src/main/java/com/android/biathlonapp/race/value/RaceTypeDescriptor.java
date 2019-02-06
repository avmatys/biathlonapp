package com.android.biathlonapp.race.value;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class RaceTypeDescriptor {

    @Retention(RetentionPolicy.SOURCE)
    @StringDef({SPRINT, INDIVIDUAL, PURSUIT, RELAY, MIXED_RELAY})
    public @interface RaceType {}

    public static final String SPRINT = "Sprint";
    public static final String INDIVIDUAL = "Individual";
    public static final String PURSUIT = "Pursuit";
    public static final String RELAY = "Relay";
    public static final String MIXED_RELAY = "Mixed relay";

    @RaceType String raceType;

    public RaceTypeDescriptor(@RaceType String raceType) {
        this.raceType = raceType;
    }
}
