package com.android.biathlonapp.util.parser;

import android.util.Log;

import com.android.biathlonapp.race.Race;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class RaceParser extends Parser<List<String>, Race> {

    private static final String TAG = "RaceParser";
    private static final String DEFAULT_DATE_PATTERN = "yyyy.MM.dd G 'at' HH:mm:ss z";
    private static final String EMPTY_STRING = "";
    private static final Race EMPTY_RACE = new Race();

    private String datePattern;

    public RaceParser() {
        super();
        this.datePattern = DEFAULT_DATE_PATTERN;
    }

    public RaceParser(List<List<String>> inputList) {
        super(inputList);
        this.datePattern = DEFAULT_DATE_PATTERN;
    }

    public RaceParser(List<List<String>> inputList, String datePattern) {
        super(inputList);
        this.datePattern = (datePattern != null) ? datePattern : DEFAULT_DATE_PATTERN;
    }

    @Override
    public List<Race> parse() {
        return getInputList().stream().
                map(this::parseRace).
                collect(Collectors.toList());
    }

    public Race parseRace(List<String> raceData) {
        if (raceData == null || raceData.size() < 3) return EMPTY_RACE;
        return new Race(parseDate(raceData.get(0)),
                Double.parseDouble(raceData.get(1)),
                raceData.get(2));
    }

    public Date parseDate(String input) {
        input = (input != null) ? input : EMPTY_STRING;
        SimpleDateFormat dateParser = new SimpleDateFormat(datePattern);
        Date date = null;
        try {
            date = dateParser.parse(input);
        } catch (ParseException e) {
            Log.e(TAG, "Failed to parse date " + input + " with pattern " + datePattern, e);
        }
        return date;
    }

}
