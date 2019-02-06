package com.android.biathlonapp.race.value;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class GenderDescriptor {

    @Retention(RetentionPolicy.SOURCE)
    @StringDef({MALE, FEMALE})
    public @interface Gender {}

    public static final String MALE = "Male";
    public static final String FEMALE = "Female";

   @Gender String gender;

    public GenderDescriptor(@Gender String gender) {
        this.gender = gender;
    }
}
