package com.android.biathlonapp.util;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {

    private static final String TAG = "DateHelper";
    private static final String EMPTY_STRING = "";
    private static final Date CURRENT_DATE = new Date();
    private static final String DATE_PATTERN = "dd.mm.yyyy";

    public static Date parseDate(String input, String datePattern) {
        input = (input != null) ? input : EMPTY_STRING;
        datePattern = (datePattern != null) ? datePattern : DATE_PATTERN;
        SimpleDateFormat dateParser = new SimpleDateFormat(datePattern);
        Date date = null;
        try {
            date = dateParser.parse(input);
        } catch (ParseException e) {
            Log.e(TAG, "Failed to parse date " + input + " with pattern " + datePattern, e);
        }
        return date;
    }

    public static String formatDate(Date date, String datePattern) {
        date = (date != null) ? date : CURRENT_DATE;
        datePattern = (datePattern != null) ? datePattern : DATE_PATTERN;
        SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);
        return dateFormatter.format(date);
    }

}
